package com.example.loginservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer id;
    private String name;
    private List<User> users;

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
