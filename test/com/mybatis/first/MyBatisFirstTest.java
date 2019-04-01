package com.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis.pojo.User;

public class MyBatisFirstTest {

	//根据id查询用户信息，得到一条记录
	@Test
	public void testfindUserById() throws IOException {
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂,传入mybatis配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//通过sqlSession操作数据库
		//第一个参数:映射文件中statement的id（namespace.statement的id)
		//第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		User user = sqlSession.selectOne("test.findUserById", 1);
		
		System.out.println(user);
		
		//释放资源
		sqlSession.close();
	}
	
	//跟据用户名称模糊查询用户列表
	@Test
	public void testfindUserByName() throws IOException {
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂,传入mybatis配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//通过sqlSession操作数据库
		List<User> list = sqlSession.selectList("test.findUserByUsername", "test");
		System.out.println(list);
		//释放资源
		sqlSession.close();
	}
	
	//添加用户信息
	@Test
	public void testinsertUser() throws IOException {
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂,传入mybatis配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//通过sqlSession操作数据库
		User user = new User();
		user.setUsername("ChangyuanWu");
		user.setPassword("thisisapassword");
		sqlSession.insert("test.insertUser", user);
		
		//提交事务
		sqlSession.commit();
		
		System.out.println(user.getId());
		//释放资源
		sqlSession.close();
	}
	
	//根据id删除用户信息
	@Test
	public void testdeleteUser() throws IOException {
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂,传入mybatis配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//通过sqlSession操作数据库
		sqlSession.delete("test.deleteUser", 11);
		
		//提交事务
		sqlSession.commit();

		//释放资源
		sqlSession.close();
	}
	
	//更新用户
	@Test
	public void testupdateUser() throws IOException {
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		//创建会话工厂,传入mybatis配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//通过sqlSession操作数据库
		User user = new User();
		user.setId(10);
		user.setUsername("testUser1");
		user.setPassword("testPassword1");
		sqlSession.update("test.updateUser", user);
		
		//提交事务
		sqlSession.commit();

		//释放资源
		sqlSession.close();
	}

}
