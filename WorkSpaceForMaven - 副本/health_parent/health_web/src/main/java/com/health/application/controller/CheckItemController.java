package com.health.application.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.health.constant.MessageConstant;
import com.health.service.CheckItemService;
import com.health.pojo.CheckItem;
import com.health.pojo.PageResult;
import com.health.pojo.QueryPageBean;
import com.health.pojo.Result;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkitem")
public class CheckItemController {
    @Reference
    private CheckItemService checkItemService;
    //新增
    @RequestMapping("/add")

    public Result add(@RequestBody CheckItem checkItem){
        try {
            checkItemService.add(checkItem);
            return new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS);
        }catch (Exception e){
            return new Result(false, MessageConstant.ADD_CHECKITEM_FAIL);
        }
    }
    //分页查询
    @RequestMapping("/findPage")
    @PreAuthorize("hasAnyAuthority('CHECKITEM_QUERY')")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = checkItemService.pageQuery(
                queryPageBean.getCurrentPage(),
                queryPageBean.getPageSize(),
                queryPageBean.getQueryString());
        return pageResult;
    }
    //删除
    @RequestMapping("/delete")
    @PreAuthorize("hasAnyAuthority('CHECKITEM_DELETE')")
    public Result delete(Integer id){
        try {
            checkItemService.delete(id);
        }catch (RuntimeException e){
            return new Result(false,e.getMessage());
        }catch (Exception e){
            return new Result(false, MessageConstant.DELETE_CHECKITEM_FAIL);
        }
        return new Result(true,MessageConstant.DELETE_CHECKITEM_SUCCESS);
    }
    //编辑
    @RequestMapping("/edit")
    public Result edit(@RequestBody CheckItem checkItem){
        try {
            checkItemService.edit(checkItem);
        }catch (Exception e){
            return new Result(false,MessageConstant.EDIT_CHECKITEM_FAIL);
        }
        return new Result(true,MessageConstant.EDIT_CHECKITEM_SUCCESS);
    }
    //通过id查找
    @RequestMapping("/findById")
    public Result findById(@RequestParam Integer id){
        try {
            CheckItem checkItem = checkItemService.findById(id);
            Result result = new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS, checkItem);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_CHECKGROUP_FAIL,null);
        }
    }
    @RequestMapping("/findAll")
    public Result findAll(){
        List<CheckItem> checkItemList = checkItemService.findAll();
        if (checkItemList != null && checkItemList.size() > 0) {
            Result result = new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS);
            result.setData(checkItemList);
            return result;

        }
        return new Result(false,MessageConstant.QUERY_CHECKITEM_FAIL);
    }
}
