package com.boot.mockito.service;

import com.boot.mockito.dao.UserDao;

public class UserService {


	private UserDao userDao;
	
	public UserService() {
		
	}
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public String getNameByUserId(Integer id) {
		String name = userDao.findNameById(id); 
		return name;
	}
	
	public String getEmailByUserId(Integer id) {
		String email = userDao.findEmailById(id);
		return email;
	}
	
	public void processLogic() {
		System.out.println("processLogic method call started");
		sendMessageToServiceBusQueue("java technologies learning");
		System.out.println();
	}
	
	public void sendMessageToServiceBusQueue(String message) {
		System.out.println("message sending over service bus queue :: " +message);		
	}
	
	
	
	public String doCallPrivateMethod(String message) {
		String formattedMessage = textFormatMessage(message);
		return formattedMessage;
	}
	private String textFormatMessage(String message) {
		return message.toUpperCase();
	}
}
