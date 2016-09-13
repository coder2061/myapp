package com.web.myapp.module.lucene;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pagehelper.StringUtil;
import com.web.myapp.module.entity.Member;

/**   
 * Function: 索引工具类 
 * @author jiangyf   
 * @since 2016年9月12日 下午6:29:56 
 * @version V1.0   
 */
public class LuceneIndex {
	private static final Logger log = LoggerFactory.getLogger(LuceneIndex.class);
	private static String indexPath = "D://lucene";
	private static Directory dir = null;
	
	/**
	 *  Directory 索引的存储位置
	 *  两种实现：
	 *  	FSDirectory，表示存储在文件系统中的索引的位置；
	 *  	RAMDirectory，表示存储在内存当中的索引的位置
	 */
	static {
		try {
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
	 * 添加索引
	 * @param member
	 * @throws Exception
	 */
	public void addIndex(Member member) throws Exception {
		// 文档对象实例
		Document doc = new Document();
		/**
		 * yes表示将数据存进索引，
		 * 如果搜索结果中需要将记录显示出来就要存进去；如果搜索结果只是显示标题之类的就可以不用存，而且内容过长不建议存进去
		 * 使用TextField类是可以用于搜索的。
		 */
		// 封装文档对象
		doc.add(new StringField("id", String.valueOf(member.getId()), Field.Store.YES));
		doc.add(new TextField("name", member.getName(), Field.Store.YES));
		doc.add(new TextField("nickname", member.getNickname(), Field.Store.YES));
		// 创建索引并添加文档对象到索引中
		IndexWriter writer = getWriter();
		writer.addDocument(doc);
		writer.close();
	}

	/**
	 * 更新索引
	 * @param Member
	 * @throws Exception
	 */
	public void updateIndex(Member member) throws Exception {
		Document doc = new Document();
		doc.add(new StringField("id", String.valueOf(member.getId()), Field.Store.YES));
		doc.add(new TextField("name", member.getName(), Field.Store.YES));
		doc.add(new TextField("nickname", member.getNickname(), Field.Store.YES));
		IndexWriter writer = getWriter();
		writer.updateDocument(new Term("id", String.valueOf(member.getId())), doc);
		writer.close();
	}

	/**
	 * 删除指定的索引
	 * @param id
	 * @throws Exception
	 */
	public void deleteIndex(String id) throws Exception {
		IndexWriter writer = getWriter();
		writer.deleteDocuments(new Term("id", id));
		// 强制删除
		writer.forceMergeDeletes();
		writer.commit();
		writer.close();
	}
	
	/**  
	* 根据需要来对搜索关键字自定义高亮样式
	* @param query
	*/
	public Highlighter setHighlighter(Query query) {
		QueryScorer scorer = new QueryScorer(query);
		Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
		SimpleHTMLFormatter formatter = new 
				SimpleHTMLFormatter("<b><font color='red'>", "</font></b>");
		Highlighter highlighter = new Highlighter(formatter, scorer);
		highlighter.setTextFragmenter(fragmenter);
		return highlighter;
	}
	
	/**
	 * 搜索方法
	 * @param queryKey 搜索关键字
	 * @throws Exception
	 */
	public List<Member> query(String queryKey) throws Exception {
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
		// 封装搜索信息为Lucene能够识别的Query对象(TermQuery, BooleanQuery, PrefixQuery)
		QueryParser parser = new QueryParser("name",analyzer);
		Query query = parser.parse(queryKey);
		QueryParser parser2 = new QueryParser("nickname",analyzer);
		Query query2 = parser2.parse(queryKey);
		BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();
		booleanQuery.add(query, BooleanClause.Occur.SHOULD);
		booleanQuery.add(query2, BooleanClause.Occur.SHOULD);
		
		// 根据索引位置读取索引
		IndexReader reader = DirectoryReader.open(dir);
		IndexSearcher searcher = new IndexSearcher(reader);
		// 执行搜索并保存搜索结果
		TopDocs hits = searcher.search(booleanQuery.build(), 100);
		
		// 根据需要来对搜索关键字自定义高亮样式
		Highlighter highlighter = setHighlighter(query);
		
		// 转化搜索结果
		List<Member> memberList = new LinkedList<Member>();
		for (ScoreDoc scoreDoc : hits.scoreDocs) {
			Document doc = searcher.doc(scoreDoc.doc);
			Member member = new Member();
			String name = doc.get("name");
			String nickname = doc.get("nickname");
			member.setId(Integer.parseInt(doc.get(("id"))));
			member.setName(name);
			member.setNickname(nickname);
			if (name != null) {
				TokenStream tokenStream = analyzer.tokenStream("name", new StringReader(name));
				String hname = highlighter.getBestFragment(tokenStream, name);
				if (StringUtil.isEmpty(hname)) {
					member.setName(name);
				} else {
					member.setName(hname);
				}
			}
			if (nickname != null) {
				TokenStream tokenStream = analyzer.tokenStream("nickname", new StringReader(nickname));
				String hnickname = highlighter.getBestFragment(tokenStream, nickname);
				if (StringUtil.isEmpty(hnickname)) {
					if (nickname.length() <= 200) {
						member.setNickname(nickname);
					} else {
						member.setNickname(nickname.substring(0, 200));
					}
				} else {
					member.setNickname(hnickname);
				}
			}
			memberList.add(member);
		}
		return memberList;
	}

}
