package com.service;

import com.Dao.LoginDao;

public class LoginService {

	LoginDao t=new LoginDao();
	
	public String SelectLoginByname(String name){
		return t.SelectLoginByname(name);
	}
}
