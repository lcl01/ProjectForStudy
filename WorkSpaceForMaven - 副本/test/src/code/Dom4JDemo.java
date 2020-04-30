package code;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class Dom4JDemo {
    @Test
    public void fun01() throws Exception {
        SAXReader reader = new SAXReader();
        InputStream is = Dom4JDemo.class.getClassLoader().getResourceAsStream("books.xml");
        Document document = reader.read(is);
        Element rootElement = document.getRootElement();
        List elements = rootElement.elements();
        Element element= (Element) elements.get(0);
        String id = element.attributeValue("id");
        System.out.println(id);
        is.close();
    }
    @Test
    public void fun02() throws Exception {
        SAXReader saxReader = new SAXReader();
        InputStream is = Dom4JDemo.class.getClassLoader().getResourceAsStream("books.xml");
        Document document = saxReader.read(is);
        Element rootElement = document.getRootElement();
        Element element = (Element) rootElement.elements().get(1);
        Element element1 = (Element) element.elements().get(0);
        System.out.println(element1.getText());
        is.close();
    }
    @Test
    public void fun03() throws Exception {
        SAXReader saxReader = new SAXReader();
        InputStream is = Dom4JDemo.class.getClassLoader().getResourceAsStream("books.xml");
        Document document = saxReader.read(is);
        Element element= (Element) document.selectSingleNode("books/apple/name");
        System.out.println(element.getText());
        is.close();
    }
    @Test
    public void fun04() throws Exception {
        SAXReader saxReader = new SAXReader();
        InputStream is = Dom4JDemo.class.getClassLoader().getResourceAsStream("books.xml");
        Document document = saxReader.read(is);
        Element element= (Element) document.selectSingleNode("//book[2]/autor");
        System.out.println(element.getText());
        is.close();
    }
    @Test
    public void fun05(){
        Qq qq = new Qq();
       Car car=(Car) Proxy.newProxyInstance(qq.getClass().getClassLoader(), qq.getClass().getInterfaces(), new InvocationHandler() {
           @Override
           public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               if("run".equals(method.getName())){
                   System.out.println("QQ加了鸡血可以跑100迈...");
                   return null;
               }
               Object result=method.invoke(qq,args);
               System.out.println("result="+result);
               return "哈哈哈";
           }
       });
       car.run();
        String str = car.addOil(93);
        System.out.println("str="+str);
    }
}
