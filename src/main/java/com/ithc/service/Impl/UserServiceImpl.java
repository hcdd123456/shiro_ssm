package com.ithc.service.Impl;

import com.ithc.Dao.UserDao;
import com.ithc.constant.MyConstant;
import com.ithc.pojo.User;
import com.ithc.service.UserService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    public User queryUserByUserName(String username) {
        return userDao.queryUserByUserName(username);
    }

    @Override
    public Integer insertUser(User user) {
        user.setSalt(UUID.randomUUID().toString());
        Sha256Hash userpassword = new Sha256Hash(user.getPassword(), user.getSalt(), MyConstant.INTERCOUNT);
        user.setPassword(userpassword.toBase64());
        return userDao.insertUser(user);
    }
}
