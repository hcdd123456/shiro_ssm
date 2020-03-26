package com.ithc.service;

import com.ithc.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    public User queryUserByUserName(@Param("username") String username);

    Integer insertUser(User user);
}
