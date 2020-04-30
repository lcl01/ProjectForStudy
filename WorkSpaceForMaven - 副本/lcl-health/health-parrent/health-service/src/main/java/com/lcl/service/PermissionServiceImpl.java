package com.lcl.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.lcl.dao.PermissionDao;
import com.lcl.pojo.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @Description:
 * @Author: yp
 */
@Service(interfaceClass = PermissionService.class)
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    /**
     * 根据角色id查询权限
     * @param roleId
     * @return
     */
    @Override
    public  Set<Permission> findByRoleId(Integer roleId) {
        return permissionDao.findByRoleId(roleId);
    }
}
