package tn.esprit.spring.services;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@WebAppConfiguration

class UserServiceImplTest {
	
	@Autowired
	IUserService us;
	
	public Role generateRandom(){
		Role[] values = Role.values();
		int length = values.length;
		int randomIndex = new Random().nextInt(length);
		return values[randomIndex];
		}
	
	@Test
	@Order(1)
	public void addUserTest(){

		User u =  new User("Nermine","Belarbi",new Date(), generateRandom());
		Assertions.assertNotNull(us.addUser(u));

	}

	@Test
	@Order(2)
	public void testRetrieveAllUsers(){
		List<User> listUsers = us.retrieveAllUsers();

		Assertions.assertTrue(listUsers.size()>=1);
	}
	

	
	
	
}
