package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dto.ResponseDto;
import com.example.Dto.UserDto;
import com.example.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/home")
	public String home()
	{
		return "index";
	}
	

	@PostMapping("/save")
	public ResponseEntity<ResponseDto> saveUser(@RequestBody UserDto userDto) {

		ResponseDto responseDto = null;

		responseDto = userService.saveUser(userDto);

		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/getUserDetails/{userId}")
	public ResponseEntity<ResponseDto> getUserById(@PathVariable Long userId) {
		ResponseDto responseDto = null;

		responseDto = userService.getUserDetailsById(userId);

		return new ResponseEntity<>(responseDto, HttpStatus.OK);

	}

	@GetMapping("/getAllUserDetails")
	public ResponseEntity<ResponseDto> getAllUserDetails() {
		ResponseDto responseDto = null;

		responseDto = userService.getAllUsers();

		return new ResponseEntity<>(responseDto, HttpStatus.OK);

	}
	@GetMapping("/getUserByUserName/{userName}")
	public ResponseEntity<ResponseDto> get(@PathVariable String userName) {
		ResponseDto responseDto = null;

		responseDto = userService.getUserByUserName(userName);

		return new ResponseEntity<>(responseDto, HttpStatus.OK);

	}

}
