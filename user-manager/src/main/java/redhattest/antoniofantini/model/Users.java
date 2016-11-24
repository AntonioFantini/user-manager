package redhattest.antoniofantini.model;

import java.io.Serializable;
import java.util.List;

public class Users implements Serializable{
	private static final long serialVersionUID = -2836848125785573595L;
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
