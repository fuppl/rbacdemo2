package com.example.loginservice.controller;

import com.alibaba.fastjson.JSON;
import com.example.loginservice.component.EncryptComponent;
import com.example.loginservice.component.MyToken;
import com.example.loginservice.entity.Role;

import com.example.loginservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class LoginController {
    @Value("${my.user}")
    private String roleUser;
    @Value("${my.admin}")
    private String roleAdmin;
    @Autowired
    private EncryptComponent encrypt;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserController userController;
    @Autowired
    private RoleController roleController;

    @PostMapping("login")
    public Map login(@RequestBody User login, HttpServletResponse response) {

         Map<String, User> map = Optional.ofNullable(userController.get(login.getId()))
//                .filter(m -> encoder.matches(login.getPassword(),m.get("user").getPassword()))
                 .filter(m -> {
                     /*
                     * todo 这里无法直接通过 map.get("user") 直接获取User类型对象，
                     *  Json这个是在网上看到的解决方案，并未奏效，至少现在没有
                     * */
//                     JSON.parseObject(JSON.toJSONString(m.get("user")), User.class).getPassword().equals(login.getPassword())
                     User user = JSON.parseObject(JSON.toJSONString(m.get("user")), User.class);
                     return user.getPassword().equals(login.getPassword());

                 })
                 .filter(m -> login.getPassword().equals(m.get("user").getPassword()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED,"用户名或密码错误"));
         User user = map.get("user");

         MyToken token = new MyToken(user.getId(),user.getRoles());
         String auth = encrypt.encryptToken(token);
         response.setHeader(MyToken.AUTHORIZATION,auth);

        // 获取用户最大权限，假设role的id越大则权限越大
         List<Role> userRoles = user.getRoles();
         Role temp = new Role(0,"temp");
         for(Role r : userRoles) {
             if (r.getId() > temp.getId()){
                 temp = r;
             }
         }
         String roleCode = temp.getName().equals("user") ? roleUser : roleAdmin;
         return Map.of("role",roleCode);
    }
}
