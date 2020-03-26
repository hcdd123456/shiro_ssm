package com.ithc.service.Impl;

import com.ithc.Dao.RoleDao;
import com.ithc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    public Set<String> queryRoleByUserName(String username) {
        return roleDao.queryRoleByUserName(username);
    }
}
