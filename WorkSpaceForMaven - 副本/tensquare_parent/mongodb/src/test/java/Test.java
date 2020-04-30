import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.After;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;

public class Test {
    private MongoClient client;
    private  MongoCollection<Document> comment;
    @Before
    public void init(){
        client=new MongoClient("127.0.0.1");
        MongoDatabase commentdb = client.getDatabase("commentdb");
        comment=commentdb.getCollection("comment");
    }
    @org.junit.Test
    public void test01(){
        //创建连接
        MongoClient client = new MongoClient("127.0.0.1",27017);
        //打开数据库
        MongoDatabase commentdb = client.getDatabase("commentdb");
        //获取集合
        MongoCollection<Document> comment = commentdb.getCollection("comment");
        //查询
        FindIterable<Document> documents = comment.find();
        for (Document document : documents) {
            System.out.println("_id：" + document.get("_id"));
            System.out.println("内容：" + document.get("content"));
            System.out.println("用户ID:" + document.get("userid"));
            System.out.println("点赞数：" + document.get("thumbup"));
        }
        client.close();
    }
    @org.junit.Test
    public void test2(){
        //查询
        FindIterable<Document> documents = comment.find(new BasicDBObject("_id", "6"));
        //查询记录获取文档集合
        for (Document document : documents) {
            System.out.println("_id：" + document.get("_id"));
            System.out.println("内容：" + document.get("content"));
            System.out.println("用户ID:" + document.get("userid"));
            System.out.println("点赞数：" + document.get("thumbup"));
        }

    }
    @org.junit.Test
    public void test3() {
        Map<String, Object> map = new HashMap();
        map.put("_id", "6");
        map.put("content", "很棒！");
        map.put("userid", "9999");
        map.put("thumbup", 123);

        Document document = new Document(map);

        comment.insertOne(document);
    }
    @org.junit.Test
    public void test4() {
        Map<String, Object> map = new HashMap();
        map.put("_id", "7");
        map.put("content", "很棒！");
        map.put("userid", "9999");
        map.put("thumbup", 123);

        Document document = new Document(map);

        comment.insertOne(document);
    }
    @org.junit.Test
    public void test5() {
        //修改的条件
        Bson filter = new BasicDBObject("_id", "6");
        //修改的数据
        Bson update = new BasicDBObject("$set", new Document("userid", "8888"));

        comment.updateOne(filter, update);
    }
    @org.junit.Test
    public void fun01(){
        Bson filter = new BasicDBObject("_id", "6");
        comment.deleteOne(filter);
    }
    @After
    public void after(){
        client.close();
    }

}
