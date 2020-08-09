package com.example.loginservice.controller;

import com.example.loginservice.feign.DataFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private DataFeignClient client;

    @GetMapping("/rolesWithUsers/{id}")
    public Map getWithUser(@PathVariable Integer id) {
        return client.getRoleWithUser(id);
    }

    @GetMapping("/rolesWithUsers")
    public Map listWithUser() {
        return client.listRoleWithUsers();
    }

    @GetMapping("/roles")
    public Map list() {
        return client.listRoles();
    }
}
