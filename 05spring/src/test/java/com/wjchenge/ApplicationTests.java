package com.wjchenge;

import com.wjchenge.homework02.Demo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private Demo demo;

    @Test
    void contextLoads() {
        System.out.println(demo);
    }

}
