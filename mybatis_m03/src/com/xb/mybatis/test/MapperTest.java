package com.xb.mybatis.test;

import com.xb.mybatis.mapper.UserMapper;
import com.xb.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;

/**
 * 测试mapper动态开发
 */
public class MapperTest {

    private SqlSessionFactory sqlSessionFactory;
    /**
     * test之前的准备
     */
    @Before
    public void beforeTest() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        sqlSessionFactory  = new SqlSessionFactoryBuilder().build(in);
    }

    /**
     * 测试mapper动态开发的crud
     *
     */
    @Test
    public void testCRUD(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(16);
        System.out.println(user);
    }

}
