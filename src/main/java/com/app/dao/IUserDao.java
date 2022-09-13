package com.app.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.User;

public interface IUserDao extends JpaRepository<User, Long>{

	
 // to get the user details by email and password
    public  User findByEmailAndPassword(String email,String password);
   
    
}
