package com.ithc.service.Impl;

import com.ithc.Dao.PermissionDao;
import com.ithc.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    public Set<String> queryAllPermissionByUserName(String username) {
        return permissionDao.queryAllPermissionByUserName(username);
    }
}
