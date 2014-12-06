package com.jasper.sab.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.jasper.sab.domain.User;

public interface UserDao {
    /**
     * 插入后，user的Id的会附上，返回insert语句执行后影响的行数
     * @param user
     * @return
     */
    @Options(useGeneratedKeys=true)
    @Insert("INSERT INTO user (name,password,age) VALUES (#{name},#{password},#{age})")
    public int insert(User user);
    
    @Update("UPDATE user set name=#{name}, password=#{password}, age=#{age} where id=#{id}")
    public int update(User user);
    
    @Select("SELECT * FROM user WHERE id=#{id}")
    public User getUserById(int id);
    
    //只能用下标0、1，不能用name、password进行搜索
    @Select("SELECT * FROM user WHERE name=#{0} AND password=#{1}")
    public User getUser(String name, String password);
    
    @Update("update user set age = IFNULL(age, 0)+1 where id=#{id}")
    //@Results({@Result(column = "age", property = "age")})
    //@Result(column = "age", property = "age")
    public int incAge(User user);
    
    @Update("update user set age = IFNULL(age, 0)+1 where id=#{0}")
    public int incAgeById(@Param("id")int id);
    
    @Select("SELECT * FROM user")
    public List<User> listAll();
}
