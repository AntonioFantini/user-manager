package redhattest.antoniofantini.service;

public class UserServiceInstance {
	
	private static UserService service;
	
	/**
	 * @return UserService implementation instance
	 */
	public static UserService getInstance(){
		if(null == service){
			synchronized (UserServiceInstance.class) {
				if(null == service){
					service = new UserServiceImpl();
				}
				
			}
		}
		return service;
	}
	
	

}
