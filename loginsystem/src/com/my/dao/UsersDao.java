package com.my.dao;

import com.my.entity.Users;

/**
 * 用户业务逻辑接口
 * @author yun
 *
 */
public interface UsersDao {

	//执行用户登陆
	public boolean usersLogin(Users user);
}
