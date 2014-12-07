package com.jasper.sab.dao.mapper;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.jasper.sab.domain.User;

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
        System.out.println(userDao.listAll());
        System.out.println(userMapper.selectUser(7));
        System.out.println(userMapper);
        User user = new User();
        user.setName("Ken");
        user.setPassword("123");
        user.setAge(22);
        int ret = userDao.insert(user);
        System.out.println(ret);
        System.out.println(user);
        user.setAge(21);
        System.out.println(userDao.update(user));
    }
    
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:appContext.xml");
        System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
        System.out.println(context.getBean("userDao"));
        System.out.println(context.getBean("userMapper"));
    }

}
