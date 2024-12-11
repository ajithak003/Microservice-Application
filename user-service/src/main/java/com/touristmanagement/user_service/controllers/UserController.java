package com.touristmanagement.user_service.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.touristmanagement.user_service.services.UserService;
import com.touristmanagement.user_service.userdto.UserRequest;
import com.touristmanagement.user_service.userdto.UserResponse;

@RestController
@RequestMapping("/api/user")
public class UserController {

	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public String createUser(@RequestBody UserRequest user) {
		
	    userService.createUser(user);
		return "User Successfully Added";
	}
	
	@GetMapping("/users")
	@ResponseStatus(HttpStatus.OK)
	public List<UserResponse> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{user-id}")
	@ResponseStatus(HttpStatus.OK)
	public UserResponse findById(@PathVariable("user-id") long userId) {
		
		return userService.findById(userId);
		
	}
	
	
}
