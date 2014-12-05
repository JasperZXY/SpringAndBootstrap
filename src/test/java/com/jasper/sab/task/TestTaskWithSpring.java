package com.jasper.sab.task;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTaskWithSpring {
    
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-task-test.xml");
        context.start();
    }
}
