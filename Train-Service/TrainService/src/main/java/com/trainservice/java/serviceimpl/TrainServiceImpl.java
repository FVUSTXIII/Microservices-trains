package com.trainservice.java.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trainservice.java.dto.ResponseDTO;
import com.trainservice.java.dto.TrainAllDetails;
import com.trainservice.java.dto.TrainAllResponseDTO;
import com.trainservice.java.dto.TrainDetails;
import com.trainservice.java.dto.TrainResponseDTO;
import com.trainservice.java.entity.Train;
import com.trainservice.java.exception.TrainListEmptyException;
import com.trainservice.java.repository.TrainRepository;
import com.trainservice.java.service.TrainService;

@Service
public class TrainServiceImpl implements TrainService{
	
	@Autowired
	TrainRepository trainRepository;

	@Override
	public TrainResponseDTO getAllTrainsDetails(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Train> trainPage = trainRepository.findAll(paging);
		List<Train> trainList = trainPage.getContent();
		//Exception 
		if (trainList.isEmpty()) {
			throw new TrainListEmptyException("There are no trains at the moment, please try again later");	
		}
		
		List<TrainDetails> trainDetailsList = trainList.stream()
				.map(train -> {
						TrainDetails trainDetail = new TrainDetails();
						BeanUtils.copyProperties(train, trainDetail);
						return trainDetail;
					}).collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO("Train Details Fetch Success", 200);
		TrainResponseDTO trainResponseDto = new TrainResponseDTO();
		trainResponseDto.setTrainList(trainDetailsList);
		trainResponseDto.setResponseDTO(responseDTO);
		return trainResponseDto;
	}

	@Override
	public TrainAllResponseDTO getTrainAllDetails(Integer trainId) {
		Optional<Train> train = trainRepository.findById(trainId);
		List<TrainAllDetails> trainAllDetails = new ArrayList<>();
		//TrainAllDetails trainAllDetails = new TrainAllDetails();
		BeanUtils.copyProperties(train, trainAllDetails);
		ResponseDTO responseDTO = new ResponseDTO("Train Information Fetched Successfully", 200);
		TrainAllResponseDTO trainAllResponseDTO = new TrainAllResponseDTO();
		trainAllResponseDTO.setTrainAllDetailsList(trainAllDetails);
		trainAllResponseDTO.setResponseDTO(responseDTO);
		return trainAllResponseDTO;
	}

	
	
	

	

}
