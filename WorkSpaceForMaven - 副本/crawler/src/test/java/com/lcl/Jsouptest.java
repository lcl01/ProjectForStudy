package com.lcl;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class Jsouptest {
    /********------**********/
    @Test
    public void fun01(){
        String strXML = "<?xml version='1.0' encoding='UTF-8'?><book><name>JavaWeb入门</name></book>";
        Document document = Jsoup.parse(strXML);
        System.out.println(document);
    }
    @Test
    public void fun02() throws Exception {
        String path = Jsouptest.class.getClassLoader().getResource("index.html").getPath();
        File file = new File(path);
        Document document = Jsoup.parse(file, "utf-8");
        Element first = document.select("#footer").first();
        Attributes attributes = first.attributes();
        for (Attribute attribute : attributes) {
            System.out.println(attribute.getKey() + ":" + attribute.getValue());
        }
//        Element footer = document.getElementById("footer");
////        Element parent = footer.parent();
//        Elements footerEle = footer.children();
//        for (Element element : footerEle) {
//            System.out.println(element.nodeName());
//        }


    }
//        Attributes attributes = footer.attributes();
//        for (Attribute attribute : attributes) {
//            System.out.println(attribute.getKey() + ":" + attribute.getValue());
//        }
//        Elements item = document.getElementsByClass("item");
//        for (Element element : item) {
//            System.out.println(element);
//        }
//        System.out.println(document);
//        Elements h3Eles = document.getElementsByTag("h3");

//        for (Element h3Ele : h3Eles) {

//            System.out.println(h3Ele);
//        }


    @Test
    public void fun03() throws Exception {
String url="https://user.qzone.qq.com/845150766/4";
        Connection connect = Jsoup.connect(url);
        Document document = connect.get();
        System.out.println(document);
    }


}
