package com.example.data.controller;

import com.example.data.entity.Role;
import com.example.data.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/role")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/roles")
    public Map list(HttpSession session) {
        List<Role> list = roleService.list();
        session.setAttribute("roles",list);
        Map map = new HashMap();
        map.put("roles",list);
        return map;
    }

    @GetMapping("/roles/{id}")
    public Map list(HttpSession session, @PathVariable Integer id) {
        Role role = roleService.get(id);
        session.setAttribute("role",role);
        Map map = new HashMap();
        map.put("role",role);
        return map;
    }

    @PostMapping("/roles/role")
    public Map save(HttpSession session, @RequestBody Role role) {
        Role save = roleService.save(role);
        session.setAttribute("role",save);
        Map map = new HashMap();
        map.put("role",role);
        return map;
    }

    @PatchMapping("/roles/{id}")
    public Map update(HttpSession session, @RequestBody Role role, @PathVariable Integer id) {
        Role update = roleService.update(role);
        session.setAttribute("updateRole",update);
        Map map = new HashMap();
        map.put("updateRole",update);
        return map;
    }

    @DeleteMapping("/roles/{id}")
    public Map delete(HttpSession session, @PathVariable Integer id) {
        roleService.delete(id);
        session.setAttribute("delete successfully", true);
        Map map = new HashMap();
        map.put("delete successfully", true);
        return map;
    }

    @GetMapping("/rolesWithUsers")
    public Map listWithUser(HttpSession session){
        List<Role> roles = roleService.listWithUser();
        session.setAttribute("roles",roles);
        Map map = new HashMap();
        map.put("rolesWithUsers",roles);
        return map;
    }

    @GetMapping("/rolesWithUsers/{id}")
    public Map getWithUser(@PathVariable Integer id, HttpSession session) {
        Role role = roleService.getWithUser(id);
        session.setAttribute("roleWithUsers",role);
        Map map = new HashMap();
        map.put("roleWithUsers",role);
        return map;
    }

}
