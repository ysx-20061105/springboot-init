package com.example.springboot.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestJob {
    // 每隔1分钟执行一次
    @Scheduled(cron = "0 */1 * * * *")
    public void test(){
        log.info("test job");
    }
}
