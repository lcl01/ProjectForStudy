package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckItem;

import java.util.List;

/**
 * @Description:
 * @Author: yp
 */
public interface CheckItemDao {
    /**
     * 新增检查项
     * @param checkItem
     */
    void add(CheckItem checkItem);

    /**
     * 条件查询(分页)
     * @param queryString
     * @return
     */
    Page<CheckItem> selectConditions(String queryString);

    /**
     * 根据checkItemId 查询数量
     * @param checkItemId
     * @return
     */
    long findCountByCheckItemId(Integer checkItemId);

    /**
     * 根据id删除
     * @param checkItemId
     */
    void deleteById(Integer checkItemId);

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
