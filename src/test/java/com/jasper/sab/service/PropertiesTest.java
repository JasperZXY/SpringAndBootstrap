package com.jasper.sab.service;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.config.PropertyResourceConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.support.PropertiesLoaderSupport;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;


/**
 * 测试获取properties中的配置信息
 * @author Jasper
 */
@Ignore
@ContextConfiguration(locations = { "classpath:appContext.xml" })
public class PropertiesTest extends AbstractJUnit4SpringContextTests {
    private final static Logger LOGGER = LoggerFactory.getLogger(PropertiesTest.class);
    @Value("${project_name}")
    private String projectName1;
    @Value("${dev}")
    private Boolean dev1;
    
    @Value("#{settings['project_name']}")
    private String projectName2;
    @Value("#{settings['dev']}")
    private Boolean dev2;
    
    
    @Test
    public void get() {
        LOGGER.info("projectName1:" + projectName1);
        LOGGER.info("dev1:" + dev1);
        LOGGER.info("projectName2:" + projectName2);
        LOGGER.info("dev2:" + dev2);
    }
    
    public static void main(String[] args) {
        LOGGER.info("test");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:appContext.xml");
        System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
        Map<String, PropertyPlaceholderConfigurer> configurerMap = context.getBeansOfType(PropertyPlaceholderConfigurer.class);
        Properties properties1 = getProperties(configurerMap.values());
        System.out.println("properties1:" + properties1);
        Properties properties2 = (Properties) context.getBean("settings");
        System.out.println("properties2:" + properties2);
    }
    
    public static Properties getProperties(Collection<PropertyPlaceholderConfigurer> configurerSet) {
        Properties properties = new Properties();
        try {
            Method mergeProperties = PropertiesLoaderSupport.class.getDeclaredMethod("mergeProperties");  
            mergeProperties.setAccessible(true);
            for (PropertyPlaceholderConfigurer configurer : configurerSet) {
                Properties props = (Properties) mergeProperties.invoke(configurer);  
                Method convertProperties = PropertyResourceConfigurer.class.getDeclaredMethod("convertProperties", Properties.class);  
                convertProperties.setAccessible(true);
                convertProperties.invoke(configurer, props);
                properties.putAll(props);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

}
