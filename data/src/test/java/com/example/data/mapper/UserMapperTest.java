package com.example.data.mapper;

import com.example.data.dao.UserMapper;
import com.example.data.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class UserMapperTest {
    @Autowired
    private UserMapper mapper;

    @Test
    public void test_save() {
        User user = new User();
        user.setName("new");
        user.setPassword("123456");
        mapper.save(user);
    }

    @Test
    public void test_get() {
        User user = mapper.get(2);
        System.out.println(user.getName());
        System.out.println(user);
    }

    @Test
    public void test_update() {
        User user = new User();
        user.setId(1);
        user.setName("update");
        user.setPassword("456123");
        mapper.update(user);
    }

    @Test
    public void test_delete() {
        mapper.deleteById(6);
    }

    @Test
    public void test_listWithRole() {
        mapper.listWithRole().forEach(user -> System.out.println(user.getName() + " / "
                + user.getRoles()));
    }

    @Test
    public void test_listByNameAndPassword() {
        User user = new User();
        user.setName("update");
        user.setPassword("456123");
        List<User> users = mapper.listByNameAndPassword(user);
        users.forEach(user1 -> System.out.println(user1));
    }
}
