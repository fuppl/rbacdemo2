package com.example.data.mapper;

import com.example.data.dao.RoleMapper;
import com.example.data.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RoleMapperTest {

    @Autowired
    private RoleMapper mapper;

    @Test
    public void test_list() {
        mapper.list().forEach(role -> System.out.println(role.getName()));
    }

    @Test
    public void test_listWith(){
        mapper.listWithUser().forEach(role -> System.out.println(role));
    }

    @Test
    public void test_getWith() {
        Role withUser = mapper.getWithUser(1);
        System.out.println(withUser);
    }
}
