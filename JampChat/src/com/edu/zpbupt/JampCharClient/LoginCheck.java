package com.edu.zpbupt.JampCharClient;

public class LoginCheck {//设置登录密码
	private String name ;//用户名
	private String password ;//密码
	//构造方法
	public LoginCheck(String name,String password){
		this.name = name ;//传递用户名
		this.password = password ;//传递密码
	}
	//验证用户名和密码
	public boolean validate(){//验证方法
		if("y".equals(name)&&"1".equals(password)){  //判断用户名和密码是否正确
			return true ;//返回true
		}else{
			return false ;//返回false
		}
	}

}
