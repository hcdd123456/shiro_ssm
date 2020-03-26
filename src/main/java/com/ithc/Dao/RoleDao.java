package com.ithc.Dao;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface RoleDao {
    public Set<String> queryRoleByUserName(@Param("username") String username);
}
