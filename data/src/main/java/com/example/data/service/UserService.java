package com.example.data.service;

import com.example.data.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 保存用户
     *
     * @param user 用户
     * @return 保存后的用户
     */
    User save(User user);

    /**
     * 列出所有用户
     *
     * @return 所有用户
     */
    List<User> list();


    /**
     * 根据id获得用户
     *
     * @param id id
     * @return 用户
     */
    User get(Integer id);

    /**
     * 更新用户
     *
     * @param user 用户
     * @param id   id
     * @return 更新后的用户
     */
    User update(User user, Integer id);

    /**
     * 根据id删除用户
     *
     * @param id id
     */
    void delete(Integer id);

    /**
     * 根据id获取用户并返回用户的权限
     * @param id id
     * @return 带权限的用户
     */
    User getWithRole(Integer id);

    /**
     * 返回所有用户并包括起权限
     * @return 所有用户
     */
    List<User> listWithRole();

    /**
     * 根据用户的用户名和密码查询用户及其权限
     * @param user 用户，封装用户名和密码
     * @return 用户，包括权限
     */
    List<User> listByNameAndPassword(User user);
}
