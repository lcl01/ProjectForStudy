package com.lcl.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

public class QiniuUtils {
    public static String accessKey="VENICynL2UQqfr_cLjqJpOn_y766SePKcX49bZEV";
    public static String secretKey="H-ONaR9Krj8HfMwO7dHWaQkQLYTWslFWOg2FrX8u";
    public static String bucket="lcl";
    public static void upload2Qiniu(String filePath,String fileName){
        Configuration cfg = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(filePath, fileName, upToken);
            DefaultPutRet putRet =new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        } catch (QiniuException ex) {
            Response r = ex.response;
            try {
                System.out.println(r.bodyString());
            } catch (QiniuException e) {
                e.printStackTrace();
            }
        }
    }
    public static void upload2Qiniu(byte[] bytes,String fileName){
        Configuration cfg = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(cfg);
        String key = fileName;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(bytes, key, upToken);
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException e) {
            Response r = e.response;
            System.out.println(r.toString());
            try {
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                e1.printStackTrace();
            }

        }
    }
    public static void deleteFileFromQiniu(String fileName){
        Configuration cfg = new Configuration(Zone.zone2());
        String key=fileName;
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(bucket,key);
        } catch (QiniuException e) {
            System.out.println(e.code());
            System.out.println(e.response.toString());
        }

    }
}

