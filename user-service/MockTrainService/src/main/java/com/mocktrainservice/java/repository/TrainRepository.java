package com.mocktrainservice.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mocktrainservice.java.entity.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train, Integer>{
	
	

}