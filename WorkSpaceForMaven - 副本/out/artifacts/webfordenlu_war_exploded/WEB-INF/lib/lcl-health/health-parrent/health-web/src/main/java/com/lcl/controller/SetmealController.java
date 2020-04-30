package com.lcl.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lcl.constant.MessageConstant;
import com.lcl.constant.RedisConstant;
import com.lcl.entity.PageResult;
import com.lcl.entity.QueryPageBean;
import com.lcl.entity.Result;
import com.lcl.pojo.Setmeal;
import com.lcl.service.SetmealService;
import com.lcl.utils.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.UUID;
@RestController
@RequestMapping("/setmeal")
public class SetmealController {
    @Reference
    public SetmealService setmealService;
    @Autowired
    private JedisPool jedisPool;
    @RequestMapping("/upload")
    public Result upload(@RequestParam("imgFile")MultipartFile imgfile){
        try {
            String originalFilename = imgfile.getOriginalFilename();
            int lastIndexOf = originalFilename.lastIndexOf(".");
            String suffix = originalFilename.substring(lastIndexOf - 1);
            String fileName = UUID.randomUUID().toString() + suffix;
            QiniuUtils.upload2Qiniu(imgfile.getBytes(),fileName);
            jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_RESOURCES,fileName);
            return new Result(true, MessageConstant.PIC_UPLOAD_SUCCESS,fileName);
        }catch (IOException e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.PIC_UPLOAD_FAIL);
        }
    }
    @RequestMapping("/add")
    public Result add(@RequestBody Setmeal setmeal, Integer[] checkgroupIds){
        try {
            setmealService.add(setmeal,checkgroupIds);
        }catch (Exception e){
            //新增套餐失败
            return new Result(false,MessageConstant.ADD_SETMEAL_FAIL);
        }
        //新增套餐成功
        return new Result(true,MessageConstant.ADD_SETMEAL_SUCCESS);
    }
    @RequestMapping("/findAll")
    public PageResult findAll(@RequestBody QueryPageBean queryPageBean){
       PageResult pageResult = setmealService.pageQuery(
               queryPageBean.getCurrentPage(),
               queryPageBean.getPageSize(),
               queryPageBean.getQueryString()
       );
        return pageResult;
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
