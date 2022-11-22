package com.fakebili;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zzl
 * @version ${YEAR}/${MONTH}/${DAY} ${HOUR}:${MINUTE}:${SECOND}
 * @since 0.1.0
 */
@EnableScheduling
@SpringBootApplication(scanBasePackages = {"com.fakebili", "com.alibaba.cola"})
@MapperScan("com.fakebili.gateway.impl.database.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}