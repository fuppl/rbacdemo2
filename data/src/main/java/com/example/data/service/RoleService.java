package com.example.data.service;

import com.example.data.entity.Role;

import java.util.List;

public interface RoleService {
    /**
     * 保存
     *
     * @param role
     * @return
     */
    Role save(Role role);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    Role get(Integer id);

    /**
     * 查询所有
     *
     * @return
     */
    List<Role> list();

    /**
     * 修改
     *
     * @param role
     * @return
     */
    Role update(Role role);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Integer id);

    /**
     * 返回所有角色并返回该角色对应的所有用户
     * @return 所有角色
     */
    List<Role> listWithUser();

    /**
     * 根据id返回角色并返回该角色对应的所有用户
     * @param id id
     * @return 所有角色
     */
    Role getWithUser(Integer id);
}
