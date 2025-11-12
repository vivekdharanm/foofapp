package com.example.food_ordering_system.food.service;

import java.util.Optional;

import com.example.food_ordering_system.food.model.User;
import com.example.food_ordering_system.food.repository.UserRepository;

public class UserService 
{
	    private final UserRepository userRepository;

	    public UserService(UserRepository userRepository) 
	    {
	        this.userRepository = userRepository;
	    }


	    public User registerUser(User user) 
	    {
	        return userRepository.save(user);
	    }


	    public User getUserById(Long id) 
	    {
	        return userRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("User not found"));
	    }

	    
	    public Optional<User> getUserByEmail(String email) 
	    {
	        return userRepository.findByEmail(email);
	    }
	
}
