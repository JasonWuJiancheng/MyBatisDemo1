package com.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;
		
		try {
			//加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");	
			//通过驱动管理类获取数据库链接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8","root","root");
			
			//定义sql语句
			String sql = "select * from user where id=?";	
			//获取预处理statement
			preparedStatement = connection.prepareStatement(sql);
			//设置参数
			preparedStatement.setInt(1, 5);
			
			//向数据库发出sql，并获取查询结果集
			resultSet = preparedStatement.executeQuery();
			//遍历结果集
			while(resultSet.next()) {
				System.out.println(resultSet.getInt("id")+" "+resultSet.getString("username")+" "+resultSet.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//释放资源
			if(resultSet!=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement!=null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
