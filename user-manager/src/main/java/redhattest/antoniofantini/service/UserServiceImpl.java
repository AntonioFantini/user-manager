package redhattest.antoniofantini.service;

import java.io.IOException;
import java.util.List;

import redhattest.antoniofantini.exception.UserServiceException;
import redhattest.antoniofantini.model.User;
import redhattest.antoniofantini.persistence.UserDAO;
import redhattest.antoniofantini.persistence.UserDAOFactory;
import redhattest.antoniofantini.persistence.UserDAOTypes;

public class UserServiceImpl implements UserService{
	

	protected UserServiceImpl() {
		super();
	}

	@Override
	public List<User> getAllUsers() throws UserServiceException {
		try {
			return getDao().getAllUsers();
		} catch (Exception e) {
			throw new UserServiceException(e);
		}
	}

	
	private UserDAO getDao() throws IOException{
		return UserDAOFactory.getInstance(UserDAOTypes.MOCK);
	}
}
