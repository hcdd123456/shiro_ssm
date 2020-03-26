package com.ithc.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface RoleService {
    public Set<String> queryRoleByUserName(@Param("username") String username);
}
