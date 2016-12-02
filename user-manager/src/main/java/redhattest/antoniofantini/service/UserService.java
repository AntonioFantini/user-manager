package redhattest.antoniofantini.service;

import java.util.List;

import redhattest.antoniofantini.exception.UserServiceException;
import redhattest.antoniofantini.model.User;

public interface UserService {

	public abstract List<User> getAllUsers() throws UserServiceException;

	public User getUser(String email) throws UserServiceException;

	public List<User> getUsers(List<String> userEmails) throws UserServiceException;

	public User update(User user) throws UserServiceException;

	public User create(User user) throws UserServiceException;

	public User createOrUpdate(User user) throws UserServiceException;
	
	public boolean delete(User user) throws UserServiceException;
}
