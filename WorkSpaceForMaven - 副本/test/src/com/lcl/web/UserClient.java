package com.lcl.web;

import com.lcl.service.UserService;

import java.util.Scanner;

public class UserClient {
    public static void main(String[] args) {
        //1.获得用户的输入(用户名,密码..)
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username= scanner.nextLine();
        System.out.println("请输入密码:");
        String password= scanner.nextLine();
        System.out.println("请输入昵称:");
        String nickname= scanner.nextLine();

        //2.调用业务
        UserService userService = new UserService();
        boolean isSuccess =  userService.regist(username,password,nickname);

        //3.进行判断是否注册成功
        if (isSuccess){
            System.out.println("注册成功...");
        }else{
            System.out.println("注册失败...");
        }
    }
}
