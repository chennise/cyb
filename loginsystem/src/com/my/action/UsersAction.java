package com.my.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.my.dao.UsersDao;
import com.my.dao.UsersDaoImpl;
import com.my.entity.Users;
import com.opensymphony.xwork2.ModelDriven;


//模型驱动的方式接收表单数据
public class UsersAction extends SuperAction implements ModelDriven<Users>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -376438698988144690L;
	private Users user = new Users();
	//执行用户登陆的方法
	public String login() {
		UsersDao usersDao = new UsersDaoImpl();
		
		if(usersDao.usersLogin(user)){
			this.httpSession.setAttribute("loginUserName", user.getUsername());
			
			return "login_success";
		}else {
			this.addFieldError("loginError", "用户名或密码错误");
			return "login_failure";
		}
	}
	
	
	//该方法为对请求参数作检测
	//注意使用了此方法，需要在struts.xml文件的相应action中配置<result name="input">xxxx</result>
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		//trim方法为去掉字符串前后的空格
		if("".equals(user.getUsername().trim())) {
			this.addFieldError("userNameError", "用户名不能为空");
		}
		if(user.getPassword().trim().length() < 4) {
			this.addFieldError("passwordError", "密码长度不能小于4位");
		}		
	}


	//该注解表示执行该方法不调用validate方法进行参数检测
	@SkipValidation
	//执行用户退出的方法
	public String logout() {
		this.httpSession.removeAttribute("loginUserName");
		return "logout_success";
	}
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
