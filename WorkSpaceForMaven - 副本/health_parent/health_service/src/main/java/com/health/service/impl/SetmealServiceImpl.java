package com.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.health.dao.SetmealDao;
import com.health.pojo.PageResult;
import com.health.pojo.Setmeal;
import com.health.service.SetmealService;
import com.health.utils.RedisConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass=SetmealService.class)
@Transactional
public class SetmealServiceImpl implements SetmealService {
    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private SetmealDao setmealDao;
    @Override
    public void add(Setmeal setmeal, Integer[] checkgroupIds) {
        setmealDao.add(setmeal);
        if(checkgroupIds != null && checkgroupIds.length > 0){
            //绑定套餐和检查组的多对多关系
            setSetmealAndCheckGroup(setmeal.getId(),checkgroupIds);
            savePic2Redis(setmeal.getImg());
        }
    }

    @Override
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
        PageHelper.startPage(currentPage,pageSize);
        Page<Setmeal> page = setmealDao.selectByCondition(queryString);
        return new PageResult(page.getTotal(),page.getResult());
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
    public List<Map<String, Object>> findSetmealCount() {

        return setmealDao.findSetmealCount();
    }

    //将图片名称保存到Redis
    private void savePic2Redis(String pic){
        jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_DB_RESOURCES,pic);
    }
    private void setSetmealAndCheckGroup(Integer id, Integer[] checkgroupIds) {
        for (Integer checkgroupId : checkgroupIds) {
            Map<String, Integer> map = new HashMap<>();
            map.put("setmeal_id",id);
            map.put("checkgroup_id",checkgroupId);
            setmealDao.setSetmealAndCheckGroup(map);
        }
    }

}
