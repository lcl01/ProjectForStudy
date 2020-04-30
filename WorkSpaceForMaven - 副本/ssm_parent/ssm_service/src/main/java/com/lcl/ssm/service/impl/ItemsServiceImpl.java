package com.lcl.ssm.service.impl;

import com.lcl.ssm.dao.ItemsDao;
import com.lcl.ssm.domain.Items;
import com.lcl.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemsServiceImpl implements ItemsService{

  @Autowired
    private ItemsDao itemsDao;
    public List<Items> list() {
        return itemsDao.list();
    }


    public int save(Items items) {
        return itemsDao.save(items);
    }
}
