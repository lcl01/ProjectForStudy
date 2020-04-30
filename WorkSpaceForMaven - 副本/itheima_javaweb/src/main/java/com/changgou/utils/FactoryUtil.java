package com.itheima.utils;

import java.util.ResourceBundle;

public class FactoryUtil {
    private static ResourceBundle resourceBundle;
    static {
        resourceBundle = ResourceBundle.getBundle("impl");

    }
    public static Object getImplObject(String itfName){
        try {
            String className=resourceBundle.getString(itfName);
            return Class.forName(className).getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
