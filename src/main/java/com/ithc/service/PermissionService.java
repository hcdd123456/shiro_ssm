package com.ithc.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface PermissionService {
    public Set<String> queryAllPermissionByUserName( String username);
}
