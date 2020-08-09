package com.example.data.service.impl;

import com.example.data.dao.RoleMapper;
import com.example.data.entity.Role;
import com.example.data.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper mapper;

    @Override
    public Role save(Role role) {
        mapper.save(role);
        return role;
    }

    @Override
    public Role get(Integer id) {
        return mapper.get(id);
    }

    @Override
    public List<Role> list() {
        return mapper.list();
    }

    @Override
    public Role update(Role role) {
        mapper.update(role);
        return role;
    }

    @Override
    public void delete(Integer id) {
        mapper.deleteById(id);
    }

    @Override
    public List<Role> listWithUser() {
        return mapper.listWithUser();
    }

    @Override
    public Role getWithUser(Integer id) {
        return mapper.getWithUser(id);
    }
}
