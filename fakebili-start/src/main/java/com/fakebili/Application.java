package com.fakebili;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zzl
 * @date 2022/11/24 15:50:54
 * @description 启动类
 */
@EnableScheduling
@MapperScan("com.fakebili.gateway.impl.database.mapper")
@SpringBootApplication(scanBasePackages = {"com.fakebili", "com.alibaba.cola"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}