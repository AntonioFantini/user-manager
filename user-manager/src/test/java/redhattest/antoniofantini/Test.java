package redhattest.antoniofantini;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

import redhattest.antoniofantini.exception.UserServiceException;
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
	public void testDao() {
		try {
			System.out.println("Testing DAO...");
			Assert.assertNotNull(dao);
			Assert.assertNotNull(dao.getAllUsers());
			System.out.println("Test successfull!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@org.junit.Test
	public void testService() {
		try {
			System.out.println("Testing service...");
			Assert.assertNotNull(service);
			Assert.assertNotNull(service.getAllUsers());
			System.out.println("Test successfull!!");
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
