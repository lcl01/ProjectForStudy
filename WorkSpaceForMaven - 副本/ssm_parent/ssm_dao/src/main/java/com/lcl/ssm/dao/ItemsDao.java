package com.lcl.ssm.dao;

import com.lcl.ssm.domain.Items;

import java.util.List;

public interface ItemsDao {
    List<Items> list();

    /***
     * 保存操作
     * @param items
     * @return
     */
    int save(Items items);
}
