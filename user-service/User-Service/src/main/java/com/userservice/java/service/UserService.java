package com.userservice.java.service;

import com.userservice.java.dto.UserRequestDTO;
import com.userservice.java.dto.UserResponseDTO;

public interface UserService {

	UserResponseDTO loginUser(UserRequestDTO userRequestDTO);

	String verifyExistance(Integer userId);
	
}
