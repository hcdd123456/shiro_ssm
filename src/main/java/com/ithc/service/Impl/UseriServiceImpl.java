package com.ithc.service.Impl;

import com.ithc.Dao.UseriDao;
import com.ithc.pojo.Useri;
import com.ithc.service.UseriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UseriServiceImpl implements UseriService {

    @Autowired
    UseriDao useriDao;

    @Override
    public void insertUser(Useri user) {
//        System.out.println("Service插入数据");
        if(user.getId()!=null){
            useriDao.updateUser(user);
        }else {
            useriDao.insertUser(user);
        }
    }

    @Override
    public List<Useri> findAll() {
//        System.out.println("Service查询全部");
        return useriDao.findAll();
    }

    @Override
    public Useri findById(Integer id) {
        return useriDao.findById(id);
    }

    @Override
    public void delete(Integer[] id) {
        useriDao.delete(id);
    }
}
