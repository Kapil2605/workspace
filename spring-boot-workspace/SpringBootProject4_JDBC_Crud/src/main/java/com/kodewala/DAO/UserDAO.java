package com.kodewala.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.kodewala.SpringBootProject4JdbcCrudApplication;
import com.kodewala.entity.User;

@Repository
public class UserDAO {


	
	@Autowired
	private JdbcTemplate jdbcTemplate;

 
	
	public boolean insert(User u) {
		boolean flag=false;
		
		try {
			String query="INSERT INTO USER(NAME,EMAIL,GENDER,CITY) VALUES(?,?,?,?)";
			
			int count=jdbcTemplate.update(query, u.getName(),u.getEmail(),u.getGender(),u.getCity());
			
			
			if(count>0) {
				flag=true;
			}
			else {
				flag=false;
			}
		} catch (DataAccessException e) {
			flag=false;
			e.printStackTrace();
		}
		
		return flag;
	}
	
	//update query
	
	public boolean updateUser(User u) {
		boolean flag=false;
		
		try {
			String query="UPDATE USER SET NAME=?, GENDER=?, CITY=? WHERE EMAIL=?";
			
			int count=jdbcTemplate.update(query,u.getName(),u.getGender(),u.getCity(),u.getEmail());
			
			if(count>0) {
				flag=true;
			}
			else {
				flag=false;
			}
		} catch (DataAccessException e) {
			flag=false;
			e.printStackTrace();
		}
		
		return flag;
	}
	
	//delete query
	
		public boolean deleteUserByEmail(String email) {
			boolean flag=false;
			
			try {
				String query="DELETE FROM USER WHERE EMAIL=?";
				
				int count=jdbcTemplate.update(query,email);
				
				if(count>0) {
					flag=true;
				}
				else {
					flag=false;
				}
			} catch (DataAccessException e) {
				flag=false;
				e.printStackTrace();
			}
			
			return flag;
		}
		
	//select query
		public List<User> getAllUsers() {

		    String sql = "SELECT * FROM user";

		    return jdbcTemplate.query(
		            sql,
		            new UserRowMapper()
		    );
		}
		
		public class UserRowMapper implements RowMapper<User>{

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User u=new User(rs.getString("name"),
		                rs.getString("email"),
		                rs.getString("gender"),
		                rs.getString("city"));
				
				
				return u;
			}
			
		}
		
		
		//Get user by email id
		public User getUserByEmail(String email) {

	        String sql =
	        "SELECT * FROM user WHERE email=?";

	        User user =
	        jdbcTemplate.queryForObject(
	                sql,
	                new UserRowMapper(),
	                email
	        );

	        return user;
	    }
	
}
