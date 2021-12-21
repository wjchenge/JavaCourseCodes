package com.wjchenge.springkafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringKafkaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaDemoApplication.class, args);
    }

    @Autowired
    private Producer producer;

    @Bean
    ApplicationRunner runner() {
        return args -> {
            for (int i = 0; i < 10; i++) {
                producer.send(new Order(1000L + i, System.currentTimeMillis(),"USD2CNY", 6.5d));
            }
        };
    }


}
