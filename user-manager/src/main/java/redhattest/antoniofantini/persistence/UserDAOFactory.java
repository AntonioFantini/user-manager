package redhattest.antoniofantini.persistence;

import java.io.IOException;

public class UserDAOFactory {

	private static UserDAO dao;
	
	public static UserDAO getInstance(UserDAOTypes type) throws IOException {
		
		if (null == dao) {
			synchronized (UserDAOFactory.class) {
				if (null == dao) {
					if (type.equals(UserDAOTypes.MOCK)) {
						dao = new UserDAOMock();
						try {
							dao.initRepo();
						} catch (IOException e) {
							throw e;
						}
					} else if (type.equals(UserDAOTypes.DEFAULT)) {
						return null; // new UserDAOImpl(;
					}
				}
			}
		}
		return dao;

	}
}
