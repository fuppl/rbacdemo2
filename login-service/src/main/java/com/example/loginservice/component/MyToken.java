package com.example.loginservice.component;

import com.example.loginservice.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MyToken {
    public static final String AUTHORIZATION = "Authorization";
    public static final String UID = "uid";
    public static final String ROLE = "role";

    private Integer uid;
//    private RoleEnum role;
    private List<Role> roles;
}