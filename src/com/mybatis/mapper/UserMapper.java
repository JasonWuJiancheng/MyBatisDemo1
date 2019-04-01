package com.mybatis.mapper;

import java.util.List;

import com.mybatis.pojo.User;
import com.mybatis.pojo.UserCustom;
import com.mybatis.pojo.UserQueryVo;

public interface UserMapper {
	
	//用户信息综合查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	//用户信息综合查询总数
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	//根据id查询用户信息，使用resultMap输出
	public User findUserByIdResultMap(int id) throws Exception;
	
	//根据id查询用户信息
	public User findUserById(int id) throws Exception;
	
	//根据用户名模糊查询用户
	public List<User> findUserByUsername(String name) throws Exception;
	
	//添加用户信息
	public void insertUser(User user) throws Exception;

	//删除用户信息
	public void deleteUser(int id) throws Exception;
	
}
