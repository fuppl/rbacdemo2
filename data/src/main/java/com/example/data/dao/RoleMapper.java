package com.example.data.dao;

import com.example.data.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper {
    /**
     * 保存角色
     * @param role 角色
     */
    void save(Role role);

    /**
     * 获得角色
     * @param id id
     * @return 角色
     */
    Role get(Integer id);

    /**
     * 获取全部角色
     * @return 全部角色
     */
    List<Role> list();

    /**
     * 更新角色
     * @param role 角色
     * @return 更新后的角色
     */
    void update(Role role);

    /**
     * 根据id删除
     * @param id id
     */
    void deleteById(Integer id);

    List<Role> listWithUser();

    Role getWithUser(Integer id);
}
