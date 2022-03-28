package com.userservice.java.service.implementations;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.java.dto.ResponseDTO;
import com.userservice.java.dto.UserRequestDTO;
import com.userservice.java.dto.UserResponseDTO;
import com.userservice.java.entity.User;
import com.userservice.java.entity.UserActivity;
import com.userservice.java.exception.UserNotFoundException;
import com.userservice.java.repository.UserActivityRepository;
import com.userservice.java.repository.UserRepository;
import com.userservice.java.service.UserService;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserActivityRepository userActivityRepository;
	
	@Override
	public UserResponseDTO loginUser(UserRequestDTO userRequestDTO) {
		User user = userRepository.findByuserNameAndPassword(userRequestDTO.getUserName(), userRequestDTO.getPassword());
		if(user==null)
			{
			throw new UserNotFoundException("User Not Found with the given credentials: "+userRequestDTO.getUserName()+" Password "+userRequestDTO.getPassword());
			}
		ResponseDTO responseDTO = new ResponseDTO("User Login Success", 200);
		UserResponseDTO userResponseDTO = new UserResponseDTO();
		userResponseDTO.setUserId(user.getUserId());
		userResponseDTO.setResponseDTO(responseDTO);
		
		UserActivity logg = new UserActivity();
		logg.setUserId(user.getUserId());
		logg.setUserLoginDate(LocalDateTime.now());
		userActivityRepository.save(logg);
		
		return userResponseDTO;
	}

}
