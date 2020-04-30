package com.lcl.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.lcl.dao.RoleDao;
import com.lcl.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @Description:
 * @Author: yp
 */
@Service(interfaceClass = RoleService.class)
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    /**
     * 根据用户id查询角色
     * @param userId
     * @return
     */
    @Override
    public Set<Role> findByUid(Integer userId) {
        return roleDao.findByUid(userId);
    }
}
