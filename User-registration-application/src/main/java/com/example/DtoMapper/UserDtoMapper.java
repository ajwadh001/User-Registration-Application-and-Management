package com.example.DtoMapper;

import com.example.Dto.UserDto;
import com.example.model.User;

public class UserDtoMapper {

	public User mapDtoToEntity(UserDto userDto) {
		User user=new User();
		
		
		user.setUserName(userDto.getUserName());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmailId(userDto.getEmailId());
		
		return user;
	}
	
	public UserDto mapEntityToDto(User user) {
		UserDto userDto=new UserDto();
		
		
		userDto.setUserName(user.getUserName());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmailId(user.getEmailId());
		
		return userDto;
	}
}
