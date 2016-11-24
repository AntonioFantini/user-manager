package redhattest.antoniofantini.persistence;

import java.io.IOException;
import java.util.HashMap;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import redhattest.antoniofantini.model.User;
import redhattest.antoniofantini.model.Users;
import redhattest.antoniofantini.utils.JsonFReader;

public class UserDAOMock extends UserDAO {

	private static HashMap<String, User> users;
	
	@Override
	public HashMap<String, User> getAllUsers() {
		return users;
	}

	
	public void initRepo() throws IOException{
		if(null == users){
			synchronized (UserDAOMock.class) {
				if(null==users){
					users = new HashMap<String, User>();
					ObjectMapper mapper = new ObjectMapper();
					try {
						Users userContainer =  mapper.readValue(JsonFReader.getFileContent("users.json"), Users.class);
						for (User user : userContainer.getUsers()) {
							users.put(user.getEmail(), user);
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


