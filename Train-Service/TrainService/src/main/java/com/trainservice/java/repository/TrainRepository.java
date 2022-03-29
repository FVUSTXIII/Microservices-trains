package com.trainservice.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainservice.java.dto.TrainAllDetails;
import com.trainservice.java.entity.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train, Integer>{

	TrainAllDetails findByTrainId(Integer trainId);
	
	
}
