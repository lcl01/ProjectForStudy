package com.lcl.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.lcl.constant.MessageConstant;
import com.lcl.entity.PageResult;
import com.lcl.entity.QueryPageBean;
import com.lcl.entity.Result;
import com.lcl.pojo.CheckItem;
import com.lcl.service.CheckItemService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/checkitem")
public class CheckItemController {
    @Reference
    private CheckItemService checkItemService;

    @RequestMapping("/add")
    public Result add(@RequestBody CheckItem checkItem) {
        try {
            checkItemService.add(checkItem);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_CHECKITEM_FAIL);
        }
        return new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS);
    }

    @RequestMapping("/findPage")
    @PreAuthorize("hasAnyAuthority('CHECKITEM_QUERY')")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = checkItemService.pageQuery(
                queryPageBean.getCurrentPage(),
                queryPageBean.getPageSize(),
                queryPageBean.getQueryString());
        return pageResult;
    }

    @RequestMapping("/delete")
    @PreAuthorize("hasAnyAuthority('CHECKITEM_DELETE')")
    public Result delete(Integer id) {
        try {
            checkItemService.delete(id);
        } catch (RuntimeException e) {
            return new Result(false, e.getMessage());
        } catch (Exception e) {
            return new Result(false, MessageConstant.DELETE_CHECKITEM_FAIL);
        }
        return new Result(true, MessageConstant.DELETE_CHECKGROUP_SUCCESS);

    }

    @RequestMapping("/edit")
    public Result edit(@RequestBody CheckItem checkItem) {
        try {
            checkItemService.edit(checkItem);
        } catch (Exception e) {
            return new Result(false, MessageConstant.EDIT_CHECKGROUP_FAIL);
        }
        return new Result(true, MessageConstant.DELETE_CHECKGROUP_SUCCESS);
    }

    @RequestMapping("/findById")
    public Result findById(@RequestParam int id) {
        CheckItem checkItem = checkItemService.findById(id);
        return new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS, checkItem);

    }
    @RequestMapping("/findAll")
    public Result findAll(){
       List<CheckItem> checkItemList= checkItemService.findAll();
               if(checkItemList!=null && checkItemList.size()>0){
                   return new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS,checkItemList);
               }
               return new Result(false,MessageConstant.QUERY_CHECKGROUP_FAIL);
    }
}