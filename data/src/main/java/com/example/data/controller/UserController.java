package com.example.data.controller;

import com.example.data.entity.User;
import com.example.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("user")
    public Map save(HttpSession session, @RequestBody User user) {
        userService.save(user);
        session.setAttribute("user", user);

        Map map = new HashMap();
        map.put("user", user);
        return map;
    }

    @GetMapping("users")
    public Map list(HttpSession session) {
        List<User> list = userService.list();
        session.setAttribute("users", list);

        Map map = new HashMap();
        map.put("users", list);
        return map;
    }

    @GetMapping("users/{id}")
    public Map get(HttpSession session, @PathVariable Integer id) {
        User user = userService.get(id);
        session.setAttribute("user", user);
        Map map = new HashMap();
        map.put("user", user);
        return map;
    }

    @PatchMapping("users/{id}")
    public Map update(HttpSession session, @RequestBody User user, Integer id) {
        User update = userService.update(user, id);
        session.setAttribute("updateUser", update);
        Map map = new HashMap();
        map.put("updateUser", update);
        return map;
    }

    @DeleteMapping("users/{id}")
    public Map delete(@PathVariable Integer id, HttpSession session) {
        userService.delete(id);
        session.setAttribute("delete successfully", true);
        Map map = new HashMap();
        map.put("delete successfully", true);
        return map;
    }

    @GetMapping("usersWithRoles/{id}")
    public Map getWithRole(@PathVariable Integer id, HttpSession session){
        User user = userService.getWithRole(id);
        session.setAttribute("userWithRole",user);
        Map map = new HashMap();
        map.put("userWithRole",user);
        return map;
    }

    @GetMapping("usersWithRoles")
    public Map listWithRole(HttpSession session) {
        List<User> users = userService.listWithRole();
        session.setAttribute("usersWithRole",users);
        Map map = new HashMap();
        map.put("usersWithRole",users);
        return map;
    }

    @PostMapping("login")
    public Map login(@RequestBody User user, HttpSession session) {
        User u = userService.listByNameAndPassword(user).get(0);
        session.setAttribute("user",u);
        Map map = new HashMap();
        map.put("user",u);
        return map;
    }
}
