package com.lcl.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lcl.constant.RedisConstant;
import com.lcl.dao.SetmealDao;
import com.lcl.entity.PageResult;
import com.lcl.pojo.CheckItem;
import com.lcl.pojo.Setmeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = SetmealService.class)
@Transactional
public class SetmealServiceimpl implements SetmealService {
    @Autowired
    private SetmealDao setmealDao;
    @Autowired
    private JedisPool jedisPool;
    @Override
    public void add(Setmeal setmeal, Integer[] checkgroupIds) {
        setmealDao.add(setmeal);
        if(checkgroupIds !=null && checkgroupIds.length>0){
            setSetmealAndCheckGroup(setmeal.getId(),checkgroupIds);
        }
        savePic2Redis(setmeal.getImg());
    }
    public void savePic2Redis(String pic){
        jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_DB_RESOURCES,pic);
    }

    @Override
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
        PageHelper.startPage(currentPage,pageSize);
        Page <CheckItem> page=setmealDao.selectByCondition(queryString);
        return new PageResult(page.getTotal(),page.getResult()) ;
    }

    @Override
    public List<Setmeal> findAll() {
        return setmealDao.findAll();
    }

    @Override
    public Setmeal findById(int id) {
        return setmealDao.findById(id);
    }

    @Override
    public List <Map<String, Object>> findSetmealCount() {
        return setmealDao.findSetmealCount();
    }

    private void setSetmealAndCheckGroup(Integer id,Integer[] checkgroupIds){
        for (Integer checkgroupId : checkgroupIds) {
            HashMap <String, Integer> map = new HashMap <>();
            map.put("setmeal_id",id);
            map.put("checkgroup_id",checkgroupId);
            setmealDao.setSetmealAndCheckGroup(map);
        }

    }
}
