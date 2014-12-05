package com.jasper.sab.task;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {
    
    @Scheduled(cron = "0/2 * * * * ?")
    public void m1() {
        System.out.println("m1 " + new Date());
    }
    
    @Scheduled(fixedRate=2000)
    public void m2() {
        //应该是5秒一次
        System.out.println("m2 " + new Date());
        try {
            Thread.sleep(5000); //睡5秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
