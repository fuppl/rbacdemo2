package com.example.loginservice.controller;

import com.example.loginservice.entity.User;
import com.example.loginservice.feign.DataFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user/")
public class UserController {
    @Autowired
    private DataFeignClient client;

    @GetMapping("users")
    public Map list() {
        return client.listUsers();
    }

    @GetMapping("users/{id}")
    public Map<String, User> get(@PathVariable Integer id) {
        return client.getUser(id);
    }

    @PostMapping("getWithNameAndPassword")
    public Map getWithNameAndPassword(@RequestBody User user){
        return client.login(user);
    }
}
