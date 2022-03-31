package com.userservice.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userservice.java.entity.UserActivity;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity, Integer> {

}
