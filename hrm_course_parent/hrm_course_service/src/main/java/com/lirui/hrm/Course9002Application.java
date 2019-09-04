package com.lirui.hrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.lirui.hrm.mapper")
public class Course9002Application {
    public static void main(String[] args) {
        SpringApplication.run(Course9002Application.class,args);
    }
}
