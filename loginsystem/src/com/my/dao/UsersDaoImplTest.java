package com.my.dao;


import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import com.my.dao.UsersDao;
import com.my.dao.UsersDaoImpl;
import com.my.entity.Users;



public class UsersDaoImplTest {
	@Test
	public void usersLoginTest() {
		Users u=new Users(1,"zhangsan","123456");
		UsersDao usersdao = new UsersDaoImpl();
		assertEquals(true,usersdao.usersLogin(u));
	}
}
