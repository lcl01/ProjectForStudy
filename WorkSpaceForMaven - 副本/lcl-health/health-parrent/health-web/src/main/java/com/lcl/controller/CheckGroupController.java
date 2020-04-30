package com.lcl.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lcl.constant.MessageConstant;
import com.lcl.entity.PageResult;
import com.lcl.entity.QueryPageBean;
import com.lcl.entity.Result;
import com.lcl.pojo.CheckGroup;
import com.lcl.service.CheckGroupService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/checkgroup")
public class CheckGroupController{
    @Reference
    public CheckGroupService checkGroupService;
    @RequestMapping("/add")
    public Result add(@RequestBody CheckGroup checkGroup,Integer[] checkitemIds){
        try {
            checkGroupService.add(checkGroup,checkitemIds);
        } catch (Exception e) {
            return new Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);
        }
        return new Result(true,MessageConstant.ADD_CHECKGROUP_SUCCESS);
    }
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult=checkGroupService.pageQuery(
                queryPageBean.getCurrentPage(),
                queryPageBean.getPageSize(),
                queryPageBean.getQueryString()


        );
        return pageResult;
    }
    @RequestMapping("/findCheckItemIdsByCheckGroupId")
    public List<Integer> findCheckItemIdsByCheckGroupId(Integer id){
        List<Integer> list=checkGroupService.findCheckItemIdsByCheckGroupId(id);
        return list;
    }
    @RequestMapping("/edit")
    public Result edit(@RequestBody CheckGroup checkGroup,Integer[] checkitemIds){
        try {
            checkGroupService.edit(checkGroup,checkitemIds);
        } catch (Exception e) {
            return new Result(false,MessageConstant.EDIT_CHECKGROUP_FAIL);
        }
        return new Result(true,MessageConstant.EDIT_CHECKGROUP_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        CheckGroup checkGroup=checkGroupService.findById(id);
        if (checkGroup !=null) {
           return new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS,checkGroup);

        }
        return new Result(false,MessageConstant.QUERY_CHECKGROUP_FAIL);
    }
    @RequestMapping("/findAll")
    public Result findAll(){
        List<CheckGroup> checkGroupList=checkGroupService.findAll();
        if(checkGroupList !=null && checkGroupList.size()>0){
           return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS,checkGroupList);
        }
        return new Result(false,MessageConstant.QUERY_CHECKGROUP_FAIL);
    }
}
