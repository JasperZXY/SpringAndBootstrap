package com.jasper.sab.domain;

public class User {
    private int id;
    private String name;
    private String password;
    private int age;
    
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public int getAge() {
        return age;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + ", age=" + age + "]";
    }
    
}
