package redhattest.antoniofantini;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

import redhattest.antoniofantini.exception.UserServiceException;
import redhattest.antoniofantini.model.User;
import redhattest.antoniofantini.persistence.UserDAO;
import redhattest.antoniofantini.persistence.UserDAOFactory;
import redhattest.antoniofantini.persistence.UserDAOTypes;
import redhattest.antoniofantini.service.UserService;
import redhattest.antoniofantini.service.UserServiceInstance;

public class Test {
	private static UserDAO dao;
	private static UserService service;
	@BeforeClass
	public static void init() throws IOException {
		dao = UserDAOFactory.getInstance(UserDAOTypes.MOCK);
		service = UserServiceInstance.getInstance();
	}
	
	@org.junit.Test
	public void test(){
		try {
			System.out.println("Testing User Service application...");
			testDao();
			testService();
			List<User> users = service.getAllUsers();
			User user = users.get(0);
			User userTestObj = service.getUser(user.getEmail());
			Assert.assertEquals(user.getUsername(), userTestObj.getUsername());
			System.out.println("Tests ended successfully!!");
		} catch (UserServiceException e) {
			e.printStackTrace();
		}
		
	}
	
	private void testDao() {
		try {
			System.out.println("Testing DAO...");
			Assert.assertNotNull(dao);
			Assert.assertNotNull(dao.getAllUsers());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void testService() {
		try {
			System.out.println("Testing Service...");
			Assert.assertNotNull(service);
			Assert.assertNotNull(service.getAllUsers());
		} catch (UserServiceException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public static void release() {
		dao = null;
		service = null;
	}
}
