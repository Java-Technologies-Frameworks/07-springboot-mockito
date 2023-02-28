package com.boot.mockito;

import static org.hamcrest.CoreMatchers.anything;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.powermock.api.mockito.PowerMockito;
import com.boot.mockito.dao.UserDao;
import com.boot.mockito.dao.UserDaoImpl;
import com.boot.mockito.service.UserService;

public class UserServiceTest {

	@Test
	public void testGetNameByUserId() {
		UserDao mockUserDao = PowerMockito.mock(UserDao.class);
		PowerMockito.when(mockUserDao.findNameById(101)).thenReturn("Javed");
		UserService userService = new UserService(mockUserDao);
		String name = userService.getNameByUserId(101);
		assertEquals("Javed", name);
	}

	@Test
	public void testGetEmailByUserId() {
		UserDao mockDao = PowerMockito.mock(UserDaoImpl.class);
		PowerMockito.when(mockDao.findEmailById(102)).thenReturn("javed@gmail.com");
		UserService userService = new UserService(mockDao);
		String emailId = userService.getEmailByUserId(102);
		assertEquals("javed@gmail.com", emailId);
	}

	@Test
	public void testCheckProcess() {

		UserService mockService = PowerMockito.mock(UserService.class);
		try {
			PowerMockito.doNothing().when(mockService, "learningTesting", anything("Test"));
			mockService.processLogic();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	@Test
	public void testToPrivateMockMethod() throws Exception{
		UserService userService = new UserService();
		UserService spy = PowerMockito.spy(userService);
		PowerMockito.doReturn("JAVA TECHNOLOGIES AND FRAMEWORKS").when(spy, "doCallPrivateMethod", "java technologies and frameworks");
		String formattedMsg =userService.doCallPrivateMethod("java technologies and frameworks");
		assertEquals("JAVA TECHNOLOGIES AND FRAMEWORKS", formattedMsg);
	}
}
