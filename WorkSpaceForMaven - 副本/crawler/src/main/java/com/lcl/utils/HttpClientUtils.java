package com.lcl.utils;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class HttpClientUtils {
    public static void downloadFile(String url,String path){
        InputStream is = null;
        OutputStream os = null;
        try {
            //创建客户端
            CloseableHttpClient httpClient = HttpClients.createDefault();
            //创建GET请求对象
            HttpGet httpGet = new HttpGet(url);
            //执行这个GET请求，返回值是一个响应对象
            CloseableHttpResponse response = httpClient.execute(httpGet);
            //判断响应是否正确
            if(response.getStatusLine().getStatusCode() == 200){
                //如果服务器响应正确了，图片就封装在这个HttpEntity中
                HttpEntity entity = response.getEntity();
                //获取图片的输入流，相对我们来说，是入，相对服务器来说，是出
                is = entity.getContent();
                //创建图片的输出流
                os = new FileOutputStream(path);
                //使用第三方工具类复制图片
                IOUtils.copy(is,os);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭流
            IOUtils.closeQuietly(os);
            IOUtils.closeQuietly(is);
        }
    }

}
