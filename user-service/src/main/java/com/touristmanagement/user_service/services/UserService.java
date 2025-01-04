package com.touristmanagement.user_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.touristmanagement.user_service.exceptions.ResourceNotFoundException;
import com.touristmanagement.user_service.models.User;
import com.touristmanagement.user_service.repository.UserDAO;
import com.touristmanagement.user_service.userdto.UserRequest;
import com.touristmanagement.user_service.userdto.UserResponse;


@Service
public class UserService {

	UserDAO userDAO;
	
	@Autowired
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public void createUser(UserRequest userRequest) {
		
		User user = new User();	
		user.setEmailId(userRequest.getEmailId());
		user.setMobileNo(userRequest.getMobileNo());
		user.setName(userRequest.getName());
		user.setPassword(encoder.encode(userRequest.getPassword()));
		try {
		userDAO.save(user);
		}catch(Exception e){
			throw new ResourceNotFoundException("Email Id Should not be duplicated!");
		}
		
	}

	public List<UserResponse> getAllUsers() {
		
		List<User> users = userDAO.findAll();
		
		List<UserResponse> userResponse = users.stream().map(user -> mapToUserResponse(user)).toList();
		
		return userResponse;
	} 
	
	public UserResponse mapToUserResponse(User user) {
		UserResponse userResponse = new UserResponse();
		userResponse.setId(user.getId());
		userResponse.setEmailId(user.getEmailId());
		userResponse.setMobileNo(user.getMobileNo());
		userResponse.setName(user.getName());
		userResponse.setPassword("#########");
		userResponse.setStatus(user.getStatus());
		userResponse.setRegistrationDateTime(user.getregistrationDateTime());
		return userResponse;
	}

	public UserResponse findById(long userId) {
		
		User user = userDAO.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Not Exist : "+userId));
		System.out.println("Password : "+user.getPassword());
		UserResponse userResponse = mapToUserResponse(user);
		
		return userResponse;
	}

}
