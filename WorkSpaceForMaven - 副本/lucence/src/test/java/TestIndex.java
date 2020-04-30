import com.lcl.dao.BookDao;
import com.lcl.dao.impl.BookDaoImpl;
import com.lcl.pojo.Book;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;

import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class TestIndex {
    @Test
    public void testCreateIndex() throws Exception{
        //1.采集数据：(jdbc采集数据通过BookDao调用方法得到结果集)
        BookDao bookDao = new BookDaoImpl();
        List<Book> books = bookDao.queryBookList();
        //2.遍历book结果集，组装Document数据列表
        List<Document> docs = new ArrayList<>();
        Document doc = null;
        for (Book book : books) {
            //3.构建Field域，说白了就是将要存储的数据字段需要用到new TextField对象三个参数的构造方法，
            // book中有多个字段，所以创建多个Field对象。
            Field id = new TextField("id", book.getId().toString(), Field.Store.YES);
            Field name = new TextField("name", book.getName(), Field.Store.YES);
            Field price = new TextField("price", book.getPrice().toString(), Field.Store.YES);
            Field pic = new TextField("pic", book.getPic(), Field.Store.YES);
            Field desc = new TextField("desc", book.getDesc(), Field.Store.YES);
            //4.将Field域所有对象，添加到文档对象中。调用Document.add
            doc = new Document();
            doc.add(id);
            doc.add(name);
            doc.add(price);
            doc.add(pic);
            doc.add(desc);
            //记录文档对象列表
            docs.add(doc);
        }
        //5.创建一个标准分词器(Analyzer与StandardAnalyzer)，对文档中的Field域进行分词
        Analyzer analyzer = new StandardAnalyzer();
//        Analyzer analyzer = new IKAnalyzer();
        //6.指定索引储存目录，使用FSDirectory.open()方法。
        Directory directory = FSDirectory.open(new File("D:/lcl/index").toPath());
        //7.创建IndexWriterConfig对象，直接new，用于接下来创建IndexWriter对象
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        //8.创建IndexWriter对象，直接new
        IndexWriter indexWriter = new IndexWriter(directory,indexWriterConfig);
        //9.添加文档对象到索引库输出对象中，使用IndexWriter.addDocuments方法
        indexWriter.addDocuments(docs);
        //10.释放资源IndexWriter.close();
        indexWriter.close();
    }
    @Test
    public void testQuery() throws Exception{
        //1.创建一个Directory对象，FSDirectory.open指定索引库存放的位置
        Directory directory = FSDirectory.open(new File("D:/lcl/index").toPath());
        //2.创建一个IndexReader对象，DirectoryReader.open需要指定Directory对象
        IndexReader indexReader = DirectoryReader.open(directory);
        //3.创建一个Indexsearcher对象，直接new，需要指定IndexReader对象
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        //4.创建一个标准分词器(Analyzer与StandardAnalyzer)，对文档中的Field域进行分词
//        Analyzer analyzer = new StandardAnalyzer();
                Analyzer analyzer = new IKAnalyzer();

        //5.创建一个QueryParser对象， new QueryParser (域名称，分词器)
        QueryParser queryParser = new QueryParser("desc",analyzer);
        //6.调用QueryParser.parser(搜索的内容)，得到Query
        Query query = queryParser.parse("java");
        //7.执行查询，IndexSearcher.search(Query对象,查询排名靠多少名前的记录数)，得到结果TopDocs
        TopDocs topDocs = indexSearcher.search(query, 5);
        //8.遍历查询结果并输出，TopDocs.totalHits总记录数，topDocs.scoreDocs数据列表，
        // 通过scoreDoc.doc得到唯一id,再通过IndexSearcher.doc(id)，
        // 得到文档对象Document再Document.get(域名称)得到结果
        System.out.println("总记录数为：" + topDocs.totalHits);
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            int docId = scoreDoc.doc;
            Document doc = indexSearcher.doc(docId);
            System.out.println(doc.get("id") + "->" + doc.get("name") + "," + doc.get("price"));
        }
        //9.关闭IndexReader对象
        indexReader.close();
    }
}
