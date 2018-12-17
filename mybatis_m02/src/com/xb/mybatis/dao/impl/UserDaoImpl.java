package com.xb.mybatis.dao.impl;

import com.xb.mybatis.dao.UserDao;
import com.xb.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import java.util.List;

public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();    //重复
        return sqlSession.selectOne("test.findUserById",id);  //重复
    }

    @Override
    public List<User> findUserByUsername(String username) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList("test.findUserByUsername",username);
        //sqlSession的生命周期，这里用关闭么？是否浪费资源
    }

    @Override
    public void addUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("test.addUser",user);
        sqlSession.commit();    //这里需要注意提交
        sqlSession.close();
    }

    @Override
    public void updateUesrById(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("test.updateUserById",user);
        sqlSession.commit();    //这里需要注意提交
        sqlSession.close();
    }

    @Override
    public void deleteUserById(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteUserById",id);
        sqlSession.commit();    //这里需要注意提交
        sqlSession.close();
    }
}
