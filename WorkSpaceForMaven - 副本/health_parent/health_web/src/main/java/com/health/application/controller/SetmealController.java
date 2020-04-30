package com.health.application.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.health.constant.MessageConstant;
import com.health.pojo.PageResult;
import com.health.pojo.QueryPageBean;
import com.health.pojo.Result;
import com.health.pojo.Setmeal;
import com.health.service.SetmealService;
import com.health.utils.QiniuUtils;
import com.health.utils.RedisConstant;
//import MessageConstant;
//import PageResult;
//import QueryPageBean;
//import Result;
//import Setmeal;
//import SetmealService;
//import QiniuUtils;
//import RedisConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.JedisPool;

import java.util.UUID;

@RestController
@RequestMapping("/setmeal")
public class SetmealController {
    @Autowired
    private JedisPool jedisPool;
    @Reference
    private SetmealService setmealService;
    @RequestMapping("/upload")
    public Result upload(@RequestParam("imgFile") MultipartFile imgFile){
        try {
            //获取原始文件名
            String originalFilename = imgFile.getOriginalFilename();
            int lastIndexOf = originalFilename.lastIndexOf(".");
            //获取文件后缀
            String suffix = originalFilename.substring(lastIndexOf - 1);
            //使用UUID随机产生文件名称，防止同名文件覆盖
            String fileName = UUID.randomUUID().toString() + suffix;
            QiniuUtils.upload2Qiniu(imgFile.getBytes(),fileName);
            //图片上传成功
            Result result = new Result(true, MessageConstant.PIC_UPLOAD_SUCCESS);
            result.setData(fileName);
            //将上传图片名称存入Redis，基于Redis的Set集合存储
            jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_RESOURCES,fileName);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.PIC_UPLOAD_FAIL);
        }
    }
    //新增
    @RequestMapping("/add")
    public Result add(@RequestBody Setmeal setmeal, Integer[] checkgroupIds){
        try {
            setmealService.add(setmeal,checkgroupIds);
            //新增套餐成功
            return new Result(true,MessageConstant.ADD_SETMEAL_SUCCESS);
        }catch (Exception e){
            //新增套餐失败
            return new Result(false,MessageConstant.ADD_SETMEAL_FAIL);
        }
    }
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = setmealService.pageQuery(
                queryPageBean.getCurrentPage(),
                queryPageBean.getPageSize(),
                queryPageBean.getQueryString()
        );
        return pageResult;
    }

}
