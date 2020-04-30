package com.lcl.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lcl.dao.CheckGroupDao;
import com.lcl.entity.PageResult;
import com.lcl.pojo.CheckGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = CheckGroupService.class)
@Transactional
public class CheckGroupServiceImpl implements CheckGroupService {
    @Autowired
    public CheckGroupDao checkGroupDao;
    @Override
    public void add(CheckGroup checkGroup, Integer[] checkitemIds) {
        checkGroupDao.add(checkGroup);
        setCheckGroupAndCheckItem(checkGroup.getId(),checkitemIds);
    }

    @Override
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
        PageHelper.startPage(currentPage,pageSize);
        Page<CheckGroup> page=checkGroupDao.selectByCondition(queryString);
        return new PageResult(page.getTotal(),page.getResult());
    }


    @Override
    public List <Integer> findCheckItemIdsByCheckGroupId(Integer id) {
        return checkGroupDao.findCheckItemIdsByCheckGroupId(id);
    }

    @Override
    public void edit(CheckGroup checkGroup, Integer[] checkitemIds) {
        checkGroupDao.deleteAssociation(checkGroup.getId());
        setCheckGroupAndCheckItem(checkGroup.getId(),checkitemIds);
        checkGroupDao.edit(checkGroup);
    }

    @Override
    public CheckGroup findById(Integer id) {
        return checkGroupDao.findById(id);
    }

    @Override
    public List <CheckGroup> findAll() {
        return checkGroupDao.findAll();
    }

    private void setCheckGroupAndCheckItem(Integer checkGroupId, Integer[] checkitemIds) {
        if(checkitemIds !=null && checkitemIds.length>0){
            for (Integer checkitemId : checkitemIds) {
               Map<String, Integer> map = new HashMap <>();
               map.put("checkgroup_id",checkGroupId);
               map.put("checkitem_id",checkitemId);
               checkGroupDao.setCheckGroupAndCheckItem(map);
            }

        }
    }
}
