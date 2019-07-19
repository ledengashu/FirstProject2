package com.test;

import com.dao.UserDao;
import com.enity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    private UserDao userDao;
    @Before
    public void before(){
        userDao = new UserDao();
    }

    @Test
    public void test1(){
        User user = new User();
        user.setUsername("aaa");
        user.setPassword("123");

        int rows = userDao.insertUser(user);
        System.out.println(rows);
    }

    @Test
    public void test2(){
        User user = new User();
        List<User> list = userDao.findByUser(user);
        for (int i = 0; i < list.size(); i++) {
            User user1 = list.get(i);
            System.out.println(user1);
            System.out.println(user1.getUsername());
        }
    }
}
