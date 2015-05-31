package com.ivica.magentoid.a.service;

interface IMagentoService{
	void userUrlAppCode(String url, String appCode);
	
	void login(String user, String password);
	
	void logout();
	
}