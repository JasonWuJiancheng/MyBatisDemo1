package com.mybatis.pojo;

import java.util.List;

public class UserQueryVo {

	//在此类中包装需要的查询条件
	
	//传入多个id
	private List<Integer> ids;
	
	//用户查询条件
	private UserCustom userCustom;

	//其它查询条件，如：订单、商品...
	
	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
}
