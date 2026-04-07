package in.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.entity.User;

public class App 
{
    public static void main( String[] args )
    {
    	
    	//insert data into database without sql query
//        User user1=new User();
//        user1.setName("Kapil");
//        user1.setEmail("kapilkhola26@gmail.com");
//        user1.setPassword("123");
//        user1.setGender("Male");
//        user1.setCity("rewari");
        
        Configuration cfg=new Configuration();
        cfg.configure("in/config/hibernate.cfg.xml");
        
        SessionFactory sessionFactory=cfg.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        
//        try {
//        	session.save(user1);
//        	transaction.commit();
//        }catch(Exception e) {
//        	transaction.rollback();
//        	e.printStackTrace();
//        }
        
        
        
        
        //select data from database
        try {
        	User user=session.get(User.class,2L);
        	if(user!=null) {
        		System.out.println(user.getName());
        		System.out.println(user.getEmail());
        		System.out.println(user.getPassword());
        		System.out.println(user.getGender());
        		System.out.println(user.getCity());
        	}
        }catch(Exception e) {
        	e.printStackTrace();;
        }
        
        //update data operation
//        try {
//        	User user=session.get(User.class,2L);
//        	user.setCity("bengalore");
//        	session.saveOrUpdate(user);
//        	transaction.commit();
//        	System.out.println("User details updated successfully");
//        	
//        }catch(Exception e) {
//        	transaction.rollback();
//        	e.printStackTrace();;
//        	System.out.println("User details not updated");
//        }
        
      //delete data operation
        try {
        	User user=session.get(User.class,2L);
        	session.delete(user);
        	transaction.commit();
        	System.out.println("User details deleted successfully");
        	
        }catch(Exception e) {
        	transaction.rollback();
        	e.printStackTrace();;
        	System.out.println("User details not deleted");
        }
    }
}
