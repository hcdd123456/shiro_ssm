package com.ithc.test;

import com.ithc.Dao.PermissionDao;
import com.ithc.Dao.RoleDao;
import com.ithc.Dao.UserDao;
import com.ithc.Dao.UseriDao;
import com.ithc.pojo.User;
import com.ithc.pojo.Useri;
import com.ithc.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDao {

    @Test
    public void testDao(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        RoleDao roleDao = context.getBean("roleDao", RoleDao.class);
        PermissionDao permissionDao = context.getBean("permissionDao", PermissionDao.class);
        UseriDao useriDao = context.getBean("useriDao", UseriDao.class);

        Useri u = useriDao.findById(2);
        System.out.println(u);

        UserService userServiceImpl = context.getBean("userServiceImpl", UserService.class);
//        System.out.println(userServiceImpl.queryUserByUserName("zhangsan"));

        User user = userDao.queryUserByUserName("zhangsan");
//        System.out.println(roleDao.queryRoleByUserName("zhangsan"));
//        System.out.println(permissionDao.queryAllPermissionByUserName("wangwu"));
//        System.out.println(user);
    }

}
