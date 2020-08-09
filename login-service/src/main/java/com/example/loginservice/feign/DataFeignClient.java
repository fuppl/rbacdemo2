package com.example.loginservice.feign;

import com.example.loginservice.entity.Role;
import com.example.loginservice.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "data-service")
public interface DataFeignClient {
//user
    @PostMapping("/api/user/user")
    Map saveUser(User user);

    @GetMapping("/api/user/users")
    Map listUsers();

    @GetMapping("/api/user/users/{id}")
    Map getUser(@PathVariable(value = "id") Integer id);

    @PatchMapping("/api/user/users/{id}")
    Map updateUser(@PathVariable(value = "id") Integer id, @RequestBody User user);

    @DeleteMapping("/api/user/users/{id}")
    Map deleteUser(@PathVariable(value = "id") Integer id);

    @GetMapping("/api/user/usersWithRoles")
    Map listUsersWithRoles();

    @GetMapping("/api/user/usersWithRoles/{id}")
    Map getUserWithRole(@PathVariable(value = "id") Integer id);

    @PostMapping("/api/user/login")
    Map login(@RequestBody User user);

//role
    @GetMapping("/api/role/roles")
    Map listRoles();

    @GetMapping("/api/role/roles/{id}")
    Map getRole(@PathVariable(name = "id") Integer id);

    @PostMapping("/api/role/roles/role")
    Map saveRole(@RequestBody Role role);

    @PatchMapping("/api/role/roles/{id}")
    Map updateRole(@RequestBody Role role, @PathVariable(name = "id")Integer id);

    @DeleteMapping("/api/role/roles/{id}")
    Map deleteRole(@PathVariable(name = "id")Integer id);

    @GetMapping("/api/role/rolesWithUsers")
    Map listRoleWithUsers();

    @GetMapping("/api/role/rolesWithUsers/{id}")
    Map getRoleWithUser(@PathVariable(name = "id")Integer id);
}
