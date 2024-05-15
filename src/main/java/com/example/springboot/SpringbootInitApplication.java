package com.example.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {RedisAutoConfiguration.class}) // 排除redis自动配置
@MapperScan("com.example.springboot.mapper") // 扫描mapper接口
@EnableScheduling // 开启定时任务
//@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true) // 开启aop
@EnableTransactionManagement //开启注解方式的事务管理
public class SpringbootInitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootInitApplication.class, args);
    }

}
