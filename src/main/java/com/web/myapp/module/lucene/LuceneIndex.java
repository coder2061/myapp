package com.web.myapp.module.lucene;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pagehelper.StringUtil;
import com.web.myapp.core.config.CommonConfig;
import com.web.myapp.module.model.User;

/**   
 * Function: 索引工具类 
 * 	Lucene的使用主要体现在两个步骤：
 * 		1 创建索引，通过IndexWriter对不同的文件进行索引的创建，并将其保存在索引相关文件存储的位置中。
 * 		2 通过索引查寻关键字相关文档。
 * @author jiangyf   
 * @since 2016年9月12日 下午6:29:56 
 * @version V1.0   
 */
public class LuceneIndex {
	private static final Logger log = LoggerFactory.getLogger(LuceneIndex.class);
	private static String indexPath = null;
	private static Directory dir = null;
	
	/**
	 *  Directory 索引的存储位置
	 *  两种实现：
	 *  	FSDirectory，表示存储在文件系统中的索引的位置；
	 *  	RAMDirectory，表示存储在内存当中的索引的位置
	 */
	static {
		try {
			indexPath = CommonConfig.getValue("indexPath");
			dir = FSDirectory.open(Paths.get(indexPath));
		} catch (IOException e) {
			e.printStackTrace();
			log.info("Initialization error for index directory path");
		}
	}

	/**
	 * 获取IndexWriter实例
	 * @return IndexWriter
	 * @throws Exception
	 */
	public static IndexWriter getWriter() throws Exception {
		// 建立索引之前必须对文档内容进行分词处理
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
		IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
		IndexWriter writer = new IndexWriter(dir, iwc);
		return writer;
	}
	
	/**  
	* 封装文档对象 
	* @param doc
	* @param obj
	* @return Document 
	* @throws Exception 
	*/
	public static Document setDocument(Document doc, Object obj) throws Exception {
		java.lang.reflect.Field[] fields = obj.getClass().getDeclaredFields();
		for (java.lang.reflect.Field field : fields) {
			field.setAccessible(true);
			/**
			 * yes表示将数据存进索引，
			 * 如果搜索结果中需要将记录显示出来就要存进去；如果搜索结果只是显示标题之类的就可以不用存，而且内容过长不建议存进去
			 * 使用TextField类是可以用于搜索的。
			 */
			doc.add(new TextField(field.getName(), field.get(obj).toString(), Field.Store.YES));
		}
		return doc;
	}
	
	/**
	 * 添加索引
	 * @param obj
	 * @throws Exception
	 */
	public static void addIndex(Object obj) throws Exception {
		// 文档对象实例
		Document doc = new Document();
		// 封装文档对象
		doc = setDocument(doc, obj);
		// 创建索引并添加文档对象到索引中
		IndexWriter writer = getWriter();
		writer.addDocument(doc);
		writer.close();
	}
	
	/**
	 * 更新索引
	 * @param obj
	 * @param key 字段名
	 * @param value 字段值
	 * @throws Exception
	 */
	public static void updateIndex(Object obj, String key, String value) throws Exception {
		Document doc = new Document();
		doc = setDocument(doc, obj);
		IndexWriter writer = getWriter();
		writer.updateDocument(new Term(key, value), doc);
		writer.close();
	}
	
	/**
	 * 删除指定的索引
	 * @param key 字段名
	 * @param value 字段值
	 * @throws Exception
	 */
	public static void deleteIndex(String key, String value) throws Exception {
		IndexWriter writer = getWriter();
		writer.deleteDocuments(new Term(key, value));
		// 强制删除
		writer.forceMergeDeletes();
		writer.commit();
		writer.close();
	}
	
	public static void test() throws Exception {
		// 标准词法分析器
		Analyzer analyzer = new StandardAnalyzer();
	    // 保存索引至内存
	    Directory directory = new RAMDirectory();
	    IndexWriterConfig config = new IndexWriterConfig(analyzer);
	    IndexWriter writer = new IndexWriter(directory, config);
	    Document doc = new Document();
	    String text = "This is the text to be indexed.";
	    doc.add(new Field("fieldname", text, TextField.TYPE_STORED));
	    writer.addDocument(doc);
	    writer.close();
	    
	    // 读取索引
	    DirectoryReader reader = DirectoryReader.open(directory);
	    // 创建搜索器
	    IndexSearcher searcher = new IndexSearcher(reader);
	    // 调用查询方法
	    QueryParser parser = new QueryParser("fieldname", analyzer);
	    Query query = parser.parse("text");
	    ScoreDoc[] hits = searcher.search(query, 1000, null).scoreDocs;
	    Assert.assertEquals(1, hits.length);
	    // 遍历查询结果
	    for (int i = 0; i < hits.length; i++) {
	      Document hitDoc = searcher.doc(hits[i].doc);
	      Assert.assertEquals("This is the text to be indexed.", hitDoc.get("fieldname"));
	    }
	    // 关闭查询器
	    reader.close();
	    directory.close();
	}
	
	
	/**  
	* 根据需要来对搜索关键字自定义高亮样式
	* @param query
	*/
	public static Highlighter setHighlighter(Query query) {
		QueryScorer scorer = new QueryScorer(query);
		Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
		SimpleHTMLFormatter formatter = new 
				SimpleHTMLFormatter("<b><font color='red'>", "</font></b>");
		Highlighter highlighter = new Highlighter(formatter, scorer);
		highlighter.setTextFragmenter(fragmenter);
		return highlighter;
	}
	
	/**
	 * 添加索引
	 * @param member
	 * @throws Exception
	 */
	public static void addIndex(User User) throws Exception {
		// 文档对象实例
		Document doc = new Document();
		// 封装文档对象
		doc.add(new StringField("id", User.getId(), Field.Store.YES));
		doc.add(new TextField("name", User.getName(), Field.Store.YES));
		doc.add(new TextField("pswd", User.getPswd(), Field.Store.YES));
		// 创建索引并添加文档对象到索引中
		IndexWriter writer = getWriter();
		writer.addDocument(doc);
		writer.close();
	}

	/**
	 * 更新索引
	 * @param User
	 * @throws Exception
	 */
	public static void updateIndex(User User) throws Exception {
		Document doc = new Document();
		doc.add(new StringField("id", User.getId(), Field.Store.YES));
		doc.add(new TextField("name", User.getName(), Field.Store.YES));
		doc.add(new TextField("pswd", User.getPswd(), Field.Store.YES));
		IndexWriter writer = getWriter();
		writer.updateDocument(new Term("id", String.valueOf(User.getId())), doc);
		writer.close();
	}

	/**
	 * 删除指定的索引
	 * @param id
	 * @throws Exception
	 */
	public static void deleteIndex(String id) throws Exception {
		IndexWriter writer = getWriter();
		writer.deleteDocuments(new Term("id", id));
		// 强制删除
		writer.forceMergeDeletes();
		writer.commit();
		writer.close();
	}
	
	/**
	 * 搜索方法
	 * @param queryKey 搜索关键字
	 * @throws Exception
	 */
	public static List<User> query(String queryKey, String[] keys) throws Exception {
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
		// 封装搜索信息为Lucene能够识别的Query对象(TermQuery, BooleanQuery, PrefixQuery)
		/*for (String key : keys) {
			QueryParser parser = new QueryParser(key,analyzer);
			Query query = parser.parse(queryKey);
			booleanQuery.add(query, BooleanClause.Occur.SHOULD);
		}*/
		QueryParser parser = new QueryParser("id",analyzer);
		Query query = parser.parse(queryKey);
		QueryParser parser2 = new QueryParser("name",analyzer);
		Query query2 = parser2.parse(queryKey);
		QueryParser parser3 = new QueryParser("pswd",analyzer);
		Query query3 = parser3.parse(queryKey);
		BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();
		booleanQuery.add(query, BooleanClause.Occur.SHOULD);
		booleanQuery.add(query2, BooleanClause.Occur.SHOULD);
		booleanQuery.add(query3, BooleanClause.Occur.SHOULD);
		
		// 根据索引位置读取索引
		IndexReader reader = DirectoryReader.open(dir);
		IndexSearcher searcher = new IndexSearcher(reader);
		// 执行搜索并保存搜索结果
		TopDocs hits = searcher.search(booleanQuery.build(), 100);
		
		// 根据需要来对搜索关键字自定义高亮样式
		Highlighter highlighter = setHighlighter(query);
		
		// 转化搜索结果
		List<User> userList = new ArrayList<User>();
		for (ScoreDoc scoreDoc : hits.scoreDocs) {
			Document doc = searcher.doc(scoreDoc.doc);
			User user = new User();
			String id = doc.get("id");
			String name = doc.get("name");
			String pswd = doc.get("pswd");
			user.setName(id);
			user.setName(name);
			user.setPswd(pswd);
			if (id != null) {
				TokenStream tokenStream = analyzer.tokenStream("id", new StringReader(id));
				String hid = highlighter.getBestFragment(tokenStream, id);
				if (StringUtil.isEmpty(hid)) {
					user.setId(id);
				} else {
					user.setId(hid);
				}
			}
			if (name != null) {
				TokenStream tokenStream = analyzer.tokenStream("name", new StringReader(name));
				String hname = highlighter.getBestFragment(tokenStream, name);
				if (StringUtil.isEmpty(hname)) {
					user.setName(name);
				} else {
					user.setName(hname);
				}
			}
			if (pswd != null) {
				TokenStream tokenStream = analyzer.tokenStream("pswd", new StringReader(pswd));
				String hpswd = highlighter.getBestFragment(tokenStream, pswd);
				if (StringUtil.isEmpty(hpswd)) {
					user.setPswd(pswd);
				} else {
					user.setPswd(hpswd);
				}
			}
			userList.add(user);
		}
		return userList;
	}

}
