package redhattest.antoniofantini.service;

import java.io.IOException;
import java.util.List;

import redhattest.antoniofantini.exception.UserServiceException;
import redhattest.antoniofantini.model.User;
import redhattest.antoniofantini.persistence.UserDAO;
import redhattest.antoniofantini.persistence.UserDAOFactory;
import redhattest.antoniofantini.persistence.UserDAOTypes;

public class UserServiceImpl implements UserService {

	protected UserServiceImpl() {
		super();
	}

	@Override
	public List<User> getAllUsers() throws UserServiceException {
		try {
			return getDao().getAll();
		} catch (Exception e) {
			throw new UserServiceException(e);
		}
	}

	@Override
	public User getUser(String email) throws UserServiceException {
		try {
			return getDao().getUser(email);
		} catch (Exception e) {
			throw new UserServiceException(e);
		}
	}

	public List<User> getUsers(List<String> userEmails) throws UserServiceException {
		try {
			return getDao().getUsers(userEmails);
		} catch (Exception e) {
			throw new UserServiceException(e);
		}

	}

	private UserDAO getDao() throws IOException {
		return UserDAOFactory.getInstance(UserDAOTypes.MOCK);
	}

	@Override
	public User update(User user) throws UserServiceException {
		try {
			return getDao().update(user);
		} catch (Exception e) {
			throw new UserServiceException(e);
		}

	}

	@Override
	public User create(User user) throws UserServiceException {
		try {
			return getDao().create(user);
		} catch (Exception e) {
			throw new UserServiceException(e);
		}

	}

	@Override
	public User createOrUpdate(User user) throws UserServiceException {
		try {
			return getDao().createOrUpdate(user);
		} catch (Exception e) {
			throw new UserServiceException(e);
		}

	}
}
