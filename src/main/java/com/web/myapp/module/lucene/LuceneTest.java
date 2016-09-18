package com.web.myapp.module.lucene;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.web.myapp.demo.model.UserInfo;
import com.web.myapp.module.model.User;

import java.io.StringReader;
import java.nio.file.Paths;
import java.util.List;

public class LuceneTest {

    public static void search(String indexDir, String querykey) throws Exception {
        Directory dir = FSDirectory.open(Paths.get(indexDir));
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher is = new IndexSearcher(reader);
        SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
        QueryParser parser = new QueryParser("desc", analyzer);
        Query query = parser.parse(querykey);
        long start = System.currentTimeMillis();
        TopDocs hits = is.search(query, 10);
        long end = System.currentTimeMillis();
        System.out.println("匹配 "+querykey+" ，总共花费"+(end-start)+"毫秒"+"查询到"+hits.totalHits+"个记录");

        QueryScorer scorer = new QueryScorer(query);
        Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
        SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<b><font color = 'red'>","</font></b>");
        Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer);
        highlighter.setTextFragmenter(fragmenter);
        for(ScoreDoc scoreDoc : hits.scoreDocs){
            Document doc = is.doc(scoreDoc.doc);
            System.out.println(doc.get("city"));
            System.out.println(doc.get("desc"));
            String desc = doc.get("desc");
            if(desc != null){
                TokenStream tokenStream = analyzer.tokenStream("desc", new StringReader(desc));
                System.out.println(highlighter.getBestFragment(tokenStream, desc));
            }
        }
        reader.close();
    }

    public static void main(String[] args) {
//    	try {
//			new LuceneCase().index();
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
    	
//        String indexDir = "D:\\Lucene";
//        String querykey = "的城市";
        
//        try {
//            search(indexDir, querykey);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        
    	try {
    		User user = new User();
    		user.setId("1");
    		user.setName("aaa");
    		user.setPswd("bbb");
			LuceneIndex.addIndex(user);
			User user2 = new User();
			user2.setId("2");
			user2.setName("bbb");
			user2.setPswd("aaa");
			LuceneIndex.addIndex(user2);
			User user3 = new User();
			user3.setId("3");
			user3.setName("aac");
			user3.setPswd("bbd");
			LuceneIndex.addIndex(user3);
			User user4 = new User();
			user4.setId("4");
			user4.setName("abb");
			user4.setPswd("aab");
			LuceneIndex.addIndex(user4);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    	
    	try {
    		UserInfo userInfo = new UserInfo();
    		userInfo.setId(5);
    		userInfo.setUsername("aaa");
    		userInfo.setPswd("bbb");
			LuceneIndex.addIndex(userInfo);
			UserInfo userInfo2 = new UserInfo();
    		userInfo2.setId(6);
    		userInfo2.setUsername("bbb");
    		userInfo2.setPswd("aaa");
			LuceneIndex.addIndex(userInfo2);
			UserInfo userInfo3 = new UserInfo();
    		userInfo3.setId(7);
    		userInfo3.setUsername("aab");
    		userInfo3.setPswd("abb");
			LuceneIndex.addIndex(userInfo3);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    	
    	
    	
//    	try {
//			User user5 = new User();
//			user5.setName("aab");
//			user5.setPswd("bbb");
//			LuceneIndex.updateIndex(user5, "name", "aab");
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
    	
//    	try {
//			LuceneIndex.deleteIndex("id", "2");
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
    	
    	try {
    		String[] keys = {"id", "name", "pswd"};
			List<User> list = LuceneIndex.query("aaa", keys);
			for (User user : list) {
				System.out.println(user.getId() + "---" + user.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
}

