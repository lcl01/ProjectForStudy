package com.changgou.ssm.service;



import com.itheima.ssm.domain.Items;

import java.util.List;

public interface ItemsService {
    List<Items> list();

    /***
     * 增加商品
     * @param items
     * @return
     */
    int save(Items items);
}
