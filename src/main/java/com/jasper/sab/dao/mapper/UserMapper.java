package com.jasper.sab.dao.mapper;

import com.jasper.sab.domain.User;

public interface UserMapper {
    
	public void insertUser(User user);
	public User selectUser(int id);
	public void deleteUser(int id);
	public void updateUser(User user);

}
