package redhattest.antoniofantini.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import redhattest.antoniofantini.model.User;
import redhattest.antoniofantini.model.Users;
import redhattest.antoniofantini.utils.JsonFReader;

public class UserDAOMock implements UserDAO {

	private static HashMap<String, User> userMap;

	protected UserDAOMock() {
		super();
	}

	@Override
	public List<User> getAll() {
		List<User> retval = new ArrayList<User>();
		retval.addAll(userMap.values());
		return retval;
	}

	@Override
	public User getUser(String email) throws Exception {
		return userMap.get(email);
	}

	@Override
	public List<User> getUsers(List<String> userEmails) throws Exception {
		List<User> retval = new ArrayList<User>();
		for (String email : userEmails) {
			retval.add(userMap.get(email));
		}
		return retval;	
	}
	@Override
	public User update(User user) throws Exception {
		if(null==user)
			throw new IOException();
		if(null == userMap.get(user.getEmail()))
			throw new IOException();
		userMap.put(user.getEmail(), user);
		return userMap.get(user.getEmail());
		
	}
	
	@Override
	public boolean delete(User user) throws Exception {
		if(null==user)
			throw new IOException();
		if(null==userMap.get(user.getEmail()))
			return false;
		userMap.remove(user.getEmail());
		return true;
	}
	
	@Override
	public User create(User user) throws Exception {
		if(null==user)
			throw new IOException();
		if(null != userMap.get(user.getEmail()))
			throw new IOException();
		userMap.put(user.getEmail(), user);
		return userMap.get(user.getEmail());
	}
	
	@Override
	public User createOrUpdate(User user) throws Exception {
		if(null==user)
			throw new IOException();
		userMap.put(user.getEmail(), user);
		return userMap.get(user.getEmail());
	}
	
	public void initRepo() throws IOException {
		if (null == userMap) {
			synchronized (UserDAOMock.class) {
				if (null == userMap) {
					userMap = new HashMap<String, User>();
					ObjectMapper mapper = new ObjectMapper();
					try {
						Users userContainer = mapper.readValue(JsonFReader.getFileContent("users.json"), Users.class);
						for (User user : userContainer.getUsers()) {
							userMap.put(user.getEmail(), user);
						}
					} catch (JsonParseException e) {
						throw e;
					} catch (JsonMappingException e) {
						throw e;
					} catch (IOException e) {
						throw e;
					}
				}
			}
		}
	}
}
