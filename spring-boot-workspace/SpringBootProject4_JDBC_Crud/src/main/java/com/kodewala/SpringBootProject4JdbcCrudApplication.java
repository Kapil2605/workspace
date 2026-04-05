package com.kodewala;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kodewala.DAO.UserDAO;
import com.kodewala.entity.User;

@SpringBootApplication
public class SpringBootProject4JdbcCrudApplication implements CommandLineRunner {

	@Autowired
	private UserDAO userDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject4JdbcCrudApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
//		//User u1=new User("Kapil","kapilkhola26@gmail.com","male","rewari");
//		
//		User u2=new User("Aman","aman@gmail.com","male","bokaro");
//		 
//		boolean status=userDao.insert(u2);
//		
//		if(status) {
//			System.out.println("User inserted");
//		}
//		else {
//			System.out.println("User not inserted");
//		}
		
		

		//Update part

//		User u2 = userDao.getUserByEmail("aman@gmail.com");
//		u2.setCity("Ahemdabad");
//		boolean status = userDao.updateUser(u2);
//
//		if (status) {
//			System.out.println("User updated");
//		} else {
//			System.out.println("User not updated");
//		}
		
		
		//Delete user

		boolean status=userDao.deleteUserByEmail("aman@gmail.com");
		if(status) {
			System.out.println("User deleted");
		}
		else {
			System.out.println("User not deleted");
		}
		
//		List<User>list=userDao.getAllUsers();
//		for(User u:list) {
//			System.out.println("Name: "+u.getName());
//			System.out.println("Email: "+u.getEmail());
//			System.out.println("Gender: "+u.getGender());
//			System.out.println("City: "+u.getCity());
//			System.out.println("-------------------------");
//		}
		
		
	}

}
