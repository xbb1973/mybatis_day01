package com.xb.mybatis.mapper;

import com.xb.mybatis.pojo.User;

import java.util.List;

/**
 * mapper动态代理开发
 * 遵循4大原则：
 *      （1）接口和sql放在同一个类路径，名字可以不一致
 *
 *      （3）接口的
 *          方法返回值
 *          方法名
 *          方法参数
 *      要和sql中的一一对应
 *
 *      mybatis核心配置文件写法1需要不sql的namespace和接口关联，否则报错：
 *      org.apache.ibatis.binding.BindingException:
 *          Type interface com.xb.mybatis.mapper.UserMapper is not known to the MapperRegistry.
 *
 */
public interface UserMapper {
    public User findUserById(Integer id);
    public List<User> findUserByUsername(String username);
    public void addUser(User user);
    public void updateUserById(User user);
    public void deleteUserById(Integer id);
}
