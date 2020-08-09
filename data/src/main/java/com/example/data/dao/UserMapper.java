package com.example.data.dao;

import com.example.data.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    void save(User user);

    void deleteById(Integer id);

    void update(User user);

    User get(Integer id);

    User getWithRole(Integer id);

    List<User> list();

    List<User> listWithRole();

    List<User> listByNameAndPassword(User user);
}
