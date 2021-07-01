package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.Dto.ResponseDto;
import com.example.Dto.ResponseError;
import com.example.Dto.UserDto;
import com.example.DtoMapper.UserDtoMapper;
import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class UserService {
	private static final Logger LOGGER = LogManager.getLogger(UserService.class);
	
	
	@Autowired
	UserRepository userRepository;

	public ResponseDto saveUser(UserDto userDto) {
		LOGGER.info("Inside savaUser..");
		ResponseDto responseDto = null;
		Map<Object, Object> message = new HashMap<>();
		
		User user = new User();
		
		user= new UserDtoMapper().mapDtoToEntity(userDto);
		Optional<User> userNameCheck = userRepository.findByUserName(user.getUserName());
		if(userNameCheck.isEmpty()) {
		user=userRepository.save(user);
		
		responseDto = new ResponseDto(  user, null);
		}
		else {
			message.put("USERNAME", "USERNAME ALREADY EXIST SAVE FAILED" );
			responseDto = new ResponseDto(null,new ResponseError(message));
		}
		return responseDto;
	}

	public ResponseDto getUserDetailsById(Long userId) {
		LOGGER.info("Inside getUserDetailsById..");
		ResponseDto responseDto = null;
		Map<Object, Object> message = new HashMap<>();
		Optional<User> user=userRepository.findById(userId);
		if (user.isEmpty()) {
			message.put("USERID", userId+" USERID DOESNOT EXIST" );
			responseDto = new ResponseDto(null,new ResponseError(message));
		}
		else 
		responseDto = new ResponseDto( user, null);
		return responseDto ;
		
	}

	public ResponseDto getAllUsers() {
		LOGGER.info("Inside getAllUsers..");
		ResponseDto responseDto = null;
		Map<Object, Object> message = new HashMap<>();
		List<User> user=userRepository.findAll();
		if (user.isEmpty()) {
			message.put("USERS", "USERS DOESNOT EXIST" );
			responseDto = new ResponseDto(null,new ResponseError(message));
		}
		else 
		responseDto = new ResponseDto( user, null);
		return responseDto ;
	}

	public ResponseDto getUserByUserName(String userName) {
		LOGGER.info("Inside getUserByUserName..");
		ResponseDto responseDto = null;
		Map<Object, Object> message = new HashMap<>();
		Optional<User> user=userRepository.findByUserName(userName);
		if (user.isEmpty()) {
			message.put("USERNAME", userName+" USERNAME DOESNOT EXIST" );
			responseDto = new ResponseDto(null,new ResponseError(message));
		}
		else 
		responseDto = new ResponseDto( user, null);
		return responseDto ;
	}

}
