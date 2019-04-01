package com.mybatis.dao;

import java.util.List;

import com.mybatis.pojo.User;

public interface UserDao {
	
	//根据id查询用户信息
	public User findUserById(int id) throws Exception;
	
	//根据用户名模糊查询用户
	public List<User> findUserByUsername(String name) throws Exception;
	//添加用户信息
	public void insertUser(User user) throws Exception;

	//删除用户信息
	public void deleteUser(int id) throws Exception;
	
}
