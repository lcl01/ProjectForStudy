package com.lcl.service;



import com.alibaba.dubbo.config.annotation.Service;
import com.lcl.dao.CheckItemDao;
import com.lcl.pojo.CheckItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service(interfaceClass = CheckItemService.class)
@Transactional
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    private CheckItemDao checkItemDao;
    @Override
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }
}
