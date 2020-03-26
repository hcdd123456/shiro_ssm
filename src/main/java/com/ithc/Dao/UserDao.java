package com.ithc.Dao;

import com.ithc.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    User queryUserByUserName(@Param("username") String username);

    Integer insertUser(User user);
}
