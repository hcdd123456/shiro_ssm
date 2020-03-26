package com.ithc.service;

import com.ithc.pojo.Useri;

import java.util.List;

public interface UseriService {

    public void insertUser(Useri user);

    public List<Useri> findAll();

    public Useri findById(Integer id);

    public void delete(Integer[] id);
}
