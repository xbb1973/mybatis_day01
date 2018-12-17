package com.xb.mybatis.dao;

import com.xb.mybatis.pojo.User;

import java.util.List;

/**
 * 用户管理的dao
 *      定义管理用户的方法
 */
public interface UserDao {
    /**
     * 通过id查找User
     * @param id
     * @return
     */
    public User findUserById(Integer id);

    /**
     * 通过username查找users
     * @param username
     * @return
     */
    public List<User> findUserByUsername(String username);

    /**
     * 添加一个user
     * @param user
     */
    public void addUser(User user);

    /**
     * 通过id更新用户
     * @param user
     */
    public void updateUesrById(User user);

    /**
     * 通过id删除用户
     * @param id
     */
    public void deleteUserById(Integer id);


}
