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
import redhattest.antoniofantini.model.Name;
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
			User userUpdateTestCase = null;
			User userTestObj = service.getUser(user.getEmail());
			Assert.assertEquals(user.getUsername(), userTestObj.getUsername());
			
			List<String> testUserEmails = new ArrayList<String>(10);
			int i = 0;
			while (i<10){
				i++;
				int pos = getRandomUserPosition(0, users.size()-1);
				testUserEmails.add(users.get(pos).getEmail());
				if(null == userUpdateTestCase){
					userUpdateTestCase = users.get(pos);
				}
			}
			List<User> filteredUsers = service.getUsers(testUserEmails);
			for (User usr : filteredUsers) {
				Assert.assertTrue(testUserEmails.contains(usr.getEmail()));
			}
			System.out.println("Testing update user...");
			Location newLoc = new Location();
			newLoc.setCity("Fake City");
			newLoc.setState("Fake State");
			newLoc.setStreet("First street, 1");
			newLoc.setZip("1234");
			User userToUpdate = UserUtils.cloneUser(userUpdateTestCase);
			userToUpdate.setLocation(newLoc);
			User resultFromUpdate = service.update(userToUpdate);
			Assert.assertEquals(userToUpdate, resultFromUpdate);
			System.out.println("Testing create user...");
			String newEmail = "newemail@example.com";
			Name name = new Name();
			name.setTitle("Mr.");
			name.setFirst("NewFirstName");
			name.setLast("NewLastName");
			User newUser = UserUtils.cloneUser(resultFromUpdate);
			newUser.setEmail(newEmail);
			newUser.setName(name);
			User createdUser = service.create(newUser);
			Assert.assertNotNull(createdUser);
			Assert.assertNotNull(service.getUser(createdUser.getEmail()));
			System.out.println("Testing delete user...");
			boolean delete = service.delete(createdUser);
			Assert.assertNull(service.getUser(createdUser.getEmail()));
			Assert.assertTrue(delete);
			System.out.println("Tests ended successfully!!");
			
		} catch (UserServiceException e) {
			e.printStackTrace();
		}
		
	}
	
	private void testDao() {
		try {
			System.out.println("Testing DAO...");
			Assert.assertNotNull(dao);
			Assert.assertNotNull(dao.getAll());
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
