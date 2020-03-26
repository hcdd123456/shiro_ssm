package com.ithc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ithc.pojo.Useri;
import com.ithc.service.UseriService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UseriController {

    @Autowired
    UseriService useriService;

    private Map<String,Object> result=new HashMap<>();

    /**
     * 保存
     * @param useri
     * @return
     */
    @RequestMapping("/save")
    public Map<String,Object> save(Useri useri) {
        try {
            useriService.insertUser(useri);
            result.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success",false);
            result.put("msg",e.getMessage());
        }
        return result;
    }

    /**
     * 分页查询
     */
    @RequestMapping("/findAllByPage")
    public Map<String,Object> listByPage(Integer page,Integer rows){
        PageHelper.startPage(page,rows);
        List<Useri> list=useriService.findAll();
        PageInfo<Useri> pageInfo=new PageInfo<>(list);
        long total = pageInfo.getTotal();
        List<Useri> UseriList = pageInfo.getList();
        result.put("total",total);
        result.put("rows",UseriList);
        return result;
    }

    /**
     * 根据id查找
     */
    @RequestMapping("/findById")
    public Useri findById(Integer id){
        Useri useri= useriService.findById(id);
        return useri;
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Map<String,Object> delete(Integer[] id){
        try {
            useriService.delete(id);
            result.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success",false);
            result.put("msg",e.getMessage());
        }
        return result;
    }
}
