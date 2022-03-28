package com.userservice.java.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.java.dto.UserRequestDTO;
import com.userservice.java.dto.UserResponseDTO;
import com.userservice.java.service.UserService;



@RestController
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/login")
	public ResponseEntity<UserResponseDTO> loginUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
		UserResponseDTO userResponseDTO = userService.loginUser(userRequestDTO);
		return new ResponseEntity<UserResponseDTO>(userResponseDTO, HttpStatus.OK);
	}
}
