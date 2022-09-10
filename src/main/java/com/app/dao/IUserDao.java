package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.User;

public interface IUserDao extends JpaRepository<User, Long>{

}
