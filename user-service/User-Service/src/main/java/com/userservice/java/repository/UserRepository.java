package com.userservice.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userservice.java.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByuserNameAndPassword(String userName, String password);
}
