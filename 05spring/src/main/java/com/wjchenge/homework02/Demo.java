package com.wjchenge.homework02;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@Data
public class Demo {

    private User user;

    @Autowired
    private User2 user2;

    @Autowired
    private User3 user3;

    @Bean
    public User3 user3(){
        User3 user3 = new User3();
        user3.setId(200L);
        user3.setName("wjchenge3");
        return user3;
    }

}
