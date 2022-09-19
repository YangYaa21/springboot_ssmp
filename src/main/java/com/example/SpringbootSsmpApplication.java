package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan("com.example.dao.BookDao")
@SpringBootApplication
public class SpringbootSsmpApplication {

    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        float c;
        System.out.println(c = (float) (a / b)); //c = 3.0
        SpringApplication.run(SpringbootSsmpApplication.class, args);
    }

}
