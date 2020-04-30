package com.changgou.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransactionManager {
    @Autowired
    private ConnectionUtils connectionUtils;
    @Pointcut(value = "execution(* com.itheima.service..*.*(..))")
    public void pc(){}
//    @Before(value = "pc()")
    public  void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
            System.out.println("开启事务");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//    @AfterReturning(value = "pc()")
    public  void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
            System.out.println("提交事务");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//    @AfterThrowing(value = "pc()")
    public  void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
            System.out.println("回滚事务");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//    @After(value = "pc()")
    public  void release(){
        try {
            connectionUtils.getThreadConnection().close();//把连接还回连接池中
            connectionUtils.removeConnection();//线程和连接解绑
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Around(value="pc()")
    public Object around(ProceedingJoinPoint joinPoint){
        Object returnValue = null;
        try {
            this.beginTransaction(); // 开启事务
            returnValue = joinPoint.proceed(joinPoint.getArgs());
            this.commit(); // 提交事务
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            this.rollback(); // 回滚事务
        }
        finally {
            this.release(); // 释放资源
        }
        return returnValue;
    }

}
