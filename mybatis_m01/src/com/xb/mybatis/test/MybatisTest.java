package com.xb.mybatis.test;

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

public class MybatisTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void testBefore() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        this.sqlSessionFactory = sqlSessionFactory;

    }

    @Test
    public void testDemo2() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();    //单例的
        //List<User> list = sqlSession.selectList("test.findByUsername", "小");
        List<User> list = sqlSession.selectList("test.findByUsername2", "小");
        for (User user : list) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    //insertUser
    @Test
    public void testDemo3() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();    //单例的
        User user = new User();
        //user.setId(32);     //test updateUserById
        user.setUsername("Kogoro1000");
        user.setBirthday(new Date());
        user.setSex("2");
        user.setAddress("Japan");
//        int insert = sqlSession.insert("test.insertUser", user);
        sqlSession.insert("test.insertUser2",user);
       // sqlSession.update("test.updateUserById",user);
        sqlSession.commit();
        sqlSession.close();
    }

    //deleteUserById
    @Test
    public void testDemo4() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();    //单例的
        sqlSession.delete("test.deleteUserById",35);
        sqlSession.commit();
        sqlSession.close();
    }

}
