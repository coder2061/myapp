package com.web.myapp.module.lucene;

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

import com.github.pagehelper.StringUtil;
import com.web.myapp.module.entity.Member;

/**   
 * Function: 索引工具类 
 * @author jiangyf   
 * @since 2016年9月12日 下午6:29:56 
 * @version V1.0   
 */
public class LuceneIndex {
	private String indexPath = "D://lucene";
	private Directory dir = null;

	/**
	 * 获取IndexWriter实例
	 * @return IndexWriter
	 * @throws Exception
	 */
	private IndexWriter getWriter() throws Exception{
		//索引存放地址
		dir = FSDirectory.open(Paths.get(indexPath));
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
		IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
		IndexWriter writer = new IndexWriter(dir, iwc);
		return writer;
	}
	
	/**
	 * 添加博客索引
	 * @param member
	 * @throws Exception
	 */
	public void addIndex(Member member) throws Exception{
		IndexWriter writer = getWriter();
		Document doc = new Document();
		/**
		 * yes表示将数据存进索引，
		 * 如果查询结果中需要将记录显示出来就要存进去；如果查询结果只是显示标题之类的就可以不用存，而且内容过长不建议存进去
		 * 使用TextField类是可以用于查询的。
		 */
		doc.add(new StringField("id",String.valueOf(member.getId()), Field.Store.YES));
		doc.add(new TextField("name", member.getName(), Field.Store.YES));
		doc.add(new TextField("nickname",member.getNickname(), Field.Store.YES));
		writer.addDocument(doc);
		writer.close();
	}

	/**
	 * 更新博客索引
	 * @param Member
	 * @throws Exception
	 */
	public void updateIndex(Member member)throws Exception{
		IndexWriter writer = getWriter();
		Document doc = new Document();
		doc.add(new StringField("id",String.valueOf(member.getId()), Field.Store.YES));
		doc.add(new TextField("name", member.getName(), Field.Store.YES));
		doc.add(new TextField("nickname",member.getNickname(), Field.Store.YES));
		writer.updateDocument(new Term("id", String.valueOf(member.getId())), doc);
		writer.close();
	}

	/**
	 * 删除指定博客的索引
	 * @param id
	 * @throws Exception
	 */
	public void deleteIndex(String id)throws Exception{
		IndexWriter writer = getWriter();
		writer.deleteDocuments(new Term("id", id));
		// 强制删除
		writer.forceMergeDeletes();
		writer.commit();
		writer.close();
	}
	
	/**
	 * 查询用户
	 * @param queryKey 查询关键字
	 * @return
	 * @throws Exception
	 */
	public List<Member> searchBlog(String queryKey)throws Exception{
		//查询索引的位置与存放索引须一致
		dir= FSDirectory.open(Paths.get(indexPath));
		IndexReader reader = DirectoryReader.open(dir);
		IndexSearcher is = new IndexSearcher(reader);
		BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();
		SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
		//name和nickname就是我们需要进行查找的两个字段,同时在存放索引的时候要使用TextField类进行存放。
		QueryParser parser = new QueryParser("name",analyzer);
		Query query = parser.parse(queryKey);
		QueryParser parser2 = new QueryParser("nickname",analyzer);
		Query query2 = parser2.parse(queryKey);
		booleanQuery.add(query, BooleanClause.Occur.SHOULD);
		booleanQuery.add(query2, BooleanClause.Occur.SHOULD);
		TopDocs hits=is.search(booleanQuery.build(), 100);
		QueryScorer scorer = new QueryScorer(query);
		Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
		//根据需要来自定义查询关键字高亮样式
		SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<b><font color='red'>","</font></b>");
		Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer);
		highlighter.setTextFragmenter(fragmenter);
		List<Member> memberList = new LinkedList<Member>();
		for(ScoreDoc scoreDoc:hits.scoreDocs){
			Document doc = is.doc(scoreDoc.doc);
			Member member = new Member();
			String name = doc.get("name");
			String nickname = doc.get("nickname");
			member.setId(Integer.parseInt(doc.get(("id"))));
			member.setName(name);
			member.setNickname(nickname);
			if(name != null){
				TokenStream tokenStream = analyzer.tokenStream("name", new StringReader(name));
				String hname = highlighter.getBestFragment(tokenStream, name);
				if(StringUtil.isEmpty(hname)){
					member.setName(name);
				}else{
					member.setName(hname);
				}
			}
			if(nickname != null){
				TokenStream tokenStream = analyzer.tokenStream("nickname", new StringReader(nickname));
				String hContent = highlighter.getBestFragment(tokenStream, nickname);
				if(StringUtil.isEmpty(hContent)){
					if(nickname.length() <= 200){
						member.setNickname(nickname);
					}else{
						member.setNickname(nickname.substring(0, 200));
					}
				}else{
					member.setNickname(hContent);
				}
			}
			memberList.add(member);
		}
		return memberList;
	}

}
