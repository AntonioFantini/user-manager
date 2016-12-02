package redhattest.antoniofantini.persistence;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import redhattest.antoniofantini.model.User;

/**
 * @author afantini
 *
 */
public interface UserDAO {

	public List<User> getAllUsers() throws Exception;
	public User getUser(String email) throws Exception;
	public List<User> getUsers(List<String> userEmails) throws Exception;

	/**Call this method in order to initialize DAO
	 * @throws IOException
	 */
	public abstract void initRepo() throws IOException;

}
