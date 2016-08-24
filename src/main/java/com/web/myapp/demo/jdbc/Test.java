package com.web.myapp.demo.jdbc;

import com.web.myapp.demo.model.UserInfo;

public class Test {
	public static void main(String[] args) {
		UserInfo userInfo = new UserInfo(1, "lisi", "123");
		UserInfo userInfo2 = new UserInfo(2, "lisi", "123");
		System.out.println(userInfo.toString()+"-----"+userInfo2.toString()+userInfo.toString().equals(userInfo2.toString()));
	}

}
