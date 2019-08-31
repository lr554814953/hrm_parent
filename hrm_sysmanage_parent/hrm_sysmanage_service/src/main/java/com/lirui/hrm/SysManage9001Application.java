package com.lirui.hrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //开启客户端支持
@MapperScan("com.lirui.hrm.mapper")
public class SysManage9001Application {
    public static void main(String[] args) {
        SpringApplication.run(SysManage9001Application.class,args);
    }
}
