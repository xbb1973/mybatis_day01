package com.xb.mybatis.test;

import com.xb.mybatis.dao.UserDao;
import com.xb.mybatis.dao.impl.UserDaoImpl;
import com.xb.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class DaoTest {

    private  SqlSessionFactory sqlSessionFactory;
    /**
     *
     */
    @Before
    public void beforeTest() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 测试dao开发
     */
    @Test
    public void testCRUD(){
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

/*        User user = userDao.findUserById(1);
        System.out.println(user);*/

/*        List<User> list = userDao.findUserByUsername("o");
        for (User user : list) {
            System.out.println(user);
        }*/

/*        User user = new User();
        user.setUsername("井之头五郎");
        user.setSex("1");
        user.setAddress("日本");
        user.setBirthday(new Date());
        userDao.addUser(user);*/

        User user = new User();
        user.setId(22);
        user.setUsername("Kogoro6090");
        user.setSex("1");
        user.setAddress("Japan");
        user.setBirthday(new Date());
        userDao.updateUesrById(user);

//        userDao.deleteUserById(49);

    }
}
