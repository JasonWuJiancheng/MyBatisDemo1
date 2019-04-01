package com.mybatis.mapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.pojo.User;
import com.mybatis.pojo.UserCustom;
import com.mybatis.pojo.UserQueryVo;

public class UserMapperTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws Exception {
		// 创建sqlSessionFactory
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂,传入mybatis配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//用户信息综合查询
	@Test
	public void testFindUserList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象(mybatis自动生成)
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("M");
		//userCustom.setUsername("test");
		
		//传入多个id
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(4);
		ids.add(5);
		//将ids传入
		userQueryVo.setIds(ids);
		userQueryVo.setUserCustom(userCustom);
		//调用userMapper方法
		List<UserCustom> list = userMapper.findUserList(userQueryVo);
		
		sqlSession.close();
		System.out.println(list);
	}
	
	//用户信息综合查询条数（分页用）
	@Test
	public void testFindUserCount() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象(mybatis自动生成)
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("M");
		userCustom.setUsername("test");
		userQueryVo.setUserCustom(userCustom);
		//调用userMapper方法，此处设置了动态sql
		int count = userMapper.findUserCount(userQueryVo);
		
		sqlSession.close();
		System.out.println(count);
	}
	
	@Test
	public void testFindUserByIdResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象(mybatis自动生成)
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//调用userMapper方法
		User user = userMapper.findUserByIdResultMap(10);
		
		sqlSession.close();
		System.out.println(user);
	}
	
	@Test
	public void testFindUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象(mybatis自动生成)
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//调用userMapper方法
		User user = userMapper.findUserById(10);
		
		sqlSession.close();
		System.out.println(user);
	}

}
