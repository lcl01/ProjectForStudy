package com.itheima.ssm.service.impl;

import com.changgou.ssm.dao.ItemsDao;
import com.itheima.ssm.domain.Items;
import com.changgou.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsDao itemsDao;
    public List<Items> list() {
        return itemsDao.list();
    }

    public int save(Items items) {
        int save = itemsDao.save(items);
        System.out.println("save" + save);
        return save;
    }
}
