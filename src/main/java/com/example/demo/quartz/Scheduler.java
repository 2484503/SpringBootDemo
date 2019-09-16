package com.example.demo.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lijn
 * @version 1.0
 * @date 2019/5/15 13:34
 */
@Component
public class Scheduler {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // 根据cron表达式定时执行
    @Scheduled(cron = "${jobs.schedule}")
    public void testTasks() {
        System.out.println("定时任务执行时间：" + dateFormat.format(new Date()));
    }
}
