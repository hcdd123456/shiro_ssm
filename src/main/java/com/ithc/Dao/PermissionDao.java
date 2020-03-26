package com.ithc.Dao;

import org.springframework.stereotype.Repository;

import java.util.Set;

public interface PermissionDao {
    public Set<String> queryAllPermissionByUserName(String username);
}
