package com.jasper.sab.dao.mapper;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@Ignore
@ContextConfiguration(locations = { "classpath:appContext.xml" })
public class UserMapperTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper userMapper;
    
    @Test
    public void m() {
        System.out.println(userDao);
        System.out.println(userDao.getUserById(7));
        System.out.println(userMapper.selectUser(7));
        System.out.println(userMapper);
    }
    
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:appContext.xml");
        System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
        System.out.println(context.getBean("userDao"));
        System.out.println(context.getBean("userMapper"));
    }

}
