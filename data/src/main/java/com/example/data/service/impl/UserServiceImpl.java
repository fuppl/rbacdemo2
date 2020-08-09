package com.example.data.service.impl;

import com.example.data.dao.UserMapper;
import com.example.data.entity.User;
import com.example.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public User save(User user) {
        mapper.save(user);
        return user;
    }

    @Override
    public List<User> list() {
        return mapper.list();
    }

    @Override
    public User get(Integer id) {
        return mapper.get(id);
    }

    // todo 后期可能需要密码校验之类的，所以不可以直接更新，需要传入id
    @Override
    public User update(User user, Integer id) {
        mapper.update(user);
        return user;
    }

    @Override
    public void delete(Integer id) {
        mapper.deleteById(id);
    }

    @Override
    public User getWithRole(Integer id) {
        return mapper.getWithRole(id);
    }

    @Override
    public List<User> listWithRole() {
        return mapper.listWithRole();
    }

    @Override
    public List<User> listByNameAndPassword(User user) {
        return mapper.listByNameAndPassword(user);
    }
}
