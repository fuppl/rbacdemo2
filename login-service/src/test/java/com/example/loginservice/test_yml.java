package com.example.loginservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class test_yml {
    @Value("${my.secretkey}")
    private String  my;

    @Test
    public void test_(){
        System.out.println(my);
    }
}
