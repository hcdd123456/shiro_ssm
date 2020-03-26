package com.ithc.Dao;

import com.ithc.pojo.Useri;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UseriDao {

    @Insert("insert into user(name,age) values(#{name},#{age})")
    public void insertUser(Useri user);

    @Select("select * from user")
    public List<Useri> findAll();

    @Select("select * from user where id=#{id}")
    public Useri findById(Integer id);

    @Update("update user set name=#{name},age=#{age} where id=#{id}")
    public void updateUser(Useri user);

    public void delete(Integer[] id);
}
