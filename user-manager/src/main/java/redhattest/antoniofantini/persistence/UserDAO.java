package redhattest.antoniofantini.persistence;

import java.io.IOException;
import java.util.HashMap;

import redhattest.antoniofantini.model.User;

public abstract class UserDAO {
	private static UserDAO dao;

	public abstract HashMap<String, User> getAllUsers();

	public abstract void initRepo() throws IOException;

	public static UserDAO getInstance(boolean mock) throws IOException {
		if (null == dao) {
			synchronized (UserDAO.class) {
				if (null == dao) {
					if (mock) {
						dao = new UserDAOMock();
						try {
							dao.initRepo();
						} catch (IOException e) {
							throw e;
						}
					} else {
						return null; // new UserDAOImpl(;
					}
				}
			}
		}
		return dao;
	}
}
