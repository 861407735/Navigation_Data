package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sz.mapper")
public class NavigationdataApplication {

    public static void main(String[] args) {
        SpringApplication.run(NavigationdataApplication.class, args);
    }

}
