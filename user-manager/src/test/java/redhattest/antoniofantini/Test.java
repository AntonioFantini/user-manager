package redhattest.antoniofantini;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;

import redhattest.antoniofantini.model.Users;
import redhattest.antoniofantini.persistence.UserDAO;
import redhattest.antoniofantini.utils.JsonFReader;

public class Test {

	@org.junit.Test
	public void test(){
		System.out.println("INFO: Testing is set correctly");
	}
	
	@org.junit.Test
	public void testDao() {
		System.out.println("Testing DAO");
		UserDAO dao = null;
		try {
			dao = UserDAO.getInstance(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(dao);
		Assert.assertNotNull(dao.getAllUsers());
	}
}
