package com.demo.org.service;

import java.util.List;

public interface AuthService {
	//获取用户权限
	public List<String> getAuth(int id);
}
