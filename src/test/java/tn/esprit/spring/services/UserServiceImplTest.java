package tn.esprit.spring.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class UserServiceImplTest {
	
	@Autowired
	IUserService us ;
	
	@Test
	@Order(1)
	public void testRetriveveAllUsers() {
		List<User> listUsers = us.retrieveAllUsers();
		Assertions.assertEquals(0, listUsers.size());
	}

	@Test
	@Order(2)
	public void testAddUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("1998-02-06");
		User u  = new User("Hamza","Rachid",d,Role.INGENIEUR);
		User userAdded = us.addUser(u);
		Assertions.assertEquals(u.getLastName(),userAdded.getLastName());
	}

	@Test
	@Order(3)
	public void testModifyUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("1998-02-06");
		User u  = new User(5L,"Hamza","Rachid",d,Role.INGENIEUR);
		User userUpdated = us.updateUser(u);
		Assertions.assertEquals(u.getLastName(),userUpdated.getLastName());
	}
	
	@Test
	@Order(4)
	public void testRetrieveUser() {
		User userRetrieved = us.retrieveUser("1");
		Assertions.assertEquals(1L,userRetrieved.getId().longValue());
	}
	
	@Test
	@Order(5)
	public void testDeleteUser() {
		us.deleteUser("3");
		Assertions.assertNull(us.retrieveUser("3"));
	}
	
	//@Test
	//public void testUpdateUser() {
	//}
	
}
