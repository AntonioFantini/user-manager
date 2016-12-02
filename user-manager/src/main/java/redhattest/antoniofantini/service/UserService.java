package redhattest.antoniofantini.service;

import java.util.List;

import redhattest.antoniofantini.exception.UserServiceException;
import redhattest.antoniofantini.model.User;

public interface UserService {

	public abstract List<User> getAllUsers() throws UserServiceException; 
	public User getUser(String email) throws UserServiceException;
	public List<User> getUsers(List<String> userEmails) throws UserServiceException;
}
