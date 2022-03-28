package com.trainservice.java.serviceimpl.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.trainservice.java.dto.TrainResponseDTO;
import com.trainservice.java.entity.Train;
import com.trainservice.java.exception.TrainListEmptyException;
import com.trainservice.java.repository.TrainRepository;
import com.trainservice.java.serviceimpl.TrainServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TrainServiceImplTest {
	
	@Mock
	TrainRepository trainRepository;
	
	@Mock
	Page<Train> page;
	
	@Mock
	List<Train> list1,list2;
	
	@Mock
	Train train1, train2;
	
	@InjectMocks
	TrainServiceImpl trainServiceImpl;
	
	Pageable paging;
	
	Page<Train> pagelist, pagelist2;
	
	
	@BeforeEach
	public void setUp() {
		
	
		list1= new ArrayList<Train>();
		list2= new ArrayList<Train>();

		train1= new Train();
		train1.setCapacity(50);
		train1.setTrainId(1);
		train1.setTrainName("Train 1");
		train1.setTrainScore(5.1);
		train1.setTrainType(3.4);
		
		train2= new Train();
		train2.setCapacity(30);
		train2.setTrainId(2);
		train2.setTrainName("Train 2");
		train2.setTrainScore(5.0);
		train2.setTrainType(4.6);
		
		list1.add(train1);
		list1.add(train2);
		
		paging = PageRequest.of(0,5);
		pagelist = new PageImpl<Train>(list1, paging, list1.size()); 
		pagelist2 = new PageImpl<Train>(list2, paging, list2.size()); 
		
		
	}
	
	
	@Test
	@DisplayName("Get all Trains details: positive")
	public void getAllStoreDetails1()
	{
		when(trainRepository.findAll(paging)).thenReturn(pagelist);
		TrainResponseDTO trainResponseDTO = trainServiceImpl.getAllTrainsDetails(0,5);
		assertNotNull(trainResponseDTO);
		
	}
	
	@Test
	@DisplayName("Get all Trains details: negative")
	public void saveProductDetailsTest2() {
		when(trainRepository.findAll(paging)).thenReturn(pagelist2);
		assertThrows(TrainListEmptyException.class, () -> trainServiceImpl.getAllTrainsDetails(0, 5));
	}
	
	
	
	
	
	
	
	

}
