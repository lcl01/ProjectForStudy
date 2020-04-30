package com.itheima.service;

import com.itheima.pojo.CheckItem;
import entity.PageResult;
import entity.QueryPageBean;
/**
 * @Description:
 * @Author: yp
 */
public interface CheckItemService {

    /**
     * 新增检查项
     * @param checkItem
     */
    void add(CheckItem checkItem);

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    PageResult findPage(QueryPageBean queryPageBean);

    /**
     * 根据id删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    CheckItem findById(Integer id);

    /**
     * 更新
     * @param checkItem
     */
    void edit(CheckItem checkItem);
}
