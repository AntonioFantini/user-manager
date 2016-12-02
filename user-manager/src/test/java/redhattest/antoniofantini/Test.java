package redhattest.antoniofantini;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

import redhattest.antoniofantini.exception.UserServiceException;
import redhattest.antoniofantini.model.Location;
import redhattest.antoniofantini.model.User;
import redhattest.antoniofantini.persistence.UserDAO;
import redhattest.antoniofantini.persistence.UserDAOFactory;
import redhattest.antoniofantini.persistence.UserDAOTypes;
import redhattest.antoniofantini.service.UserService;
import redhattest.antoniofantini.service.UserServiceInstance;
import redhattest.antoniofantini.utils.UserUtils;

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
			User userUpdateTest = null;
			User userTestObj = service.getUser(user.getEmail());
			Assert.assertEquals(user.getUsername(), userTestObj.getUsername());
			
			List<String> testUserEmails = new ArrayList<String>(10);
			int i = 0;
			while (i<10){
				i++;
				int pos = getRandomUserPosition(0, users.size()-1);
				testUserEmails.add(users.get(pos).getEmail());
				if(null == userUpdateTest){
					userUpdateTest = users.get(pos);
				}
			}
			List<User> filteredUsers = service.getUsers(testUserEmails);
			for (User usr : filteredUsers) {
				Assert.assertTrue(testUserEmails.contains(usr.getEmail()));
			}
			
			Location loc = new Location();
			loc.setCity("Fake City");
			loc.setState("Fake State");
			loc.setStreet("First street, 1");
			loc.setZip("1234");
//			User userToUpdate = UserUtils.cloneUser(userUpdateTest);
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
	
	private int getRandomUserPosition(int minimum,int maximum){
		Random rn = new Random();
		int range = maximum - minimum + 1;
		return rn.nextInt(range) + minimum;
	}
	
	@AfterClass
	public static void release() {
		dao = null;
		service = null;
	}
	
}
