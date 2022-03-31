package com.userservice.java.service.implentation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.userservice.java.dto.UserRequestDTO;
import com.userservice.java.dto.UserResponseDTO;
import com.userservice.java.entity.User;
import com.userservice.java.entity.UserActivity;
import com.userservice.java.exception.UserNotFoundException;
import com.userservice.java.repository.UserActivityRepository;
import com.userservice.java.repository.UserRepository;
import com.userservice.java.service.implementations.UserServiceImplementation;



@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

	@Mock
	UserRepository userRepository;
	
	@Mock
	UserActivityRepository userActivityRepository;
	
	@InjectMocks
	UserServiceImplementation userServiceImpl;
	
	UserRequestDTO userRequestDTO;
	UserRequestDTO userRequestDTO2;
	UserRequestDTO userRequestDTO3;
	UserResponseDTO userResponseDTO;
	
	Validator validator;
	
	User user;
	UserActivity logg;
	
	@BeforeEach
	public void setUp() {
		userRequestDTO = new UserRequestDTO();
		userRequestDTO.setUserName("Weon");
		userRequestDTO.setPassword("la wea fomme qliao");
		
		user = new User();
		user.setUserId(1);
		user.setUserName("Weon");
		user.setPassword("la wea fomme qliao");
		
		logg = new UserActivity();
		//logg.setActivityId(1);
		logg.setUserId(user.getUserId());
		logg.setUserLoginDate(LocalDateTime.now());
		
		userRequestDTO2 = new UserRequestDTO();
		userRequestDTO2.setUserName("ocyel");
		userRequestDTO2.setPassword("negative case");
		
		userRequestDTO3 = new UserRequestDTO();
		userRequestDTO3.setUserName("");
		userRequestDTO3.setPassword("");
		
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
	}
	
	@Test
	@DisplayName("User login positive")
	public void loginUserTest() {
		when(userRepository.findByuserNameAndPassword("Weon","la wea fomme qliao")).thenReturn(user);
		when(userActivityRepository.save(any(UserActivity.class))).thenReturn(logg);
		UserResponseDTO userResponseDTO = userServiceImpl.loginUser(userRequestDTO);
		assertNotNull(userResponseDTO);
		assertEquals(1, userResponseDTO.getUserId());
		assertEquals("User Login Success", userResponseDTO.getResponseDTO().getMessage());
		assertEquals(200, userResponseDTO.getResponseDTO().getStatusCode());
	}
	
	@Test
	@DisplayName("User login negative")
	public void loginUserTest1()
	{
		when(userRepository.findByuserNameAndPassword("ocyel","negative case")).thenReturn(null);
		
		assertThrows(UserNotFoundException.class, () -> userServiceImpl.loginUser(userRequestDTO2));
	}
	
	@Test
	@DisplayName("User login empty arguments")
	public void loginUserTest2()
	{
		
		 Set<ConstraintViolation<UserRequestDTO>> validations = validator.validate(userRequestDTO3);
		 assertFalse(validations.isEmpty());
	}
}
