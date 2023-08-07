package com.blog.api.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.api.entities.User;
import com.blog.api.exceptions.ResourceNotFoundException;
import com.blog.api.payloads.UserDto;
import com.blog.api.repositories.UserRepo;
import com.blog.api.services.UserService;

/**
 * Implementation of the UserService interface for managing user-related operations.]
 * @author Nishant
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Create a new user.
     */
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoTOUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    /**
     * Update an existing user by ID.
     */
    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));

        // Update user attributes and save
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User updatedUser = this.userRepo.save(user);

        // Return the updated UserDto
        return this.userToDto(updatedUser);
    }

    /**
     * Get a user by ID.
     */
    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));
        return this.userToDto(user);
    }

    /**
     * Get a list of all users.
     */
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        return users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
    }

    /**
     * Delete a user by ID.
     */
    @Override
    public void deteleUser(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        this.userRepo.delete(user);
    }

    /**
     * Map UserDto to User entity.
     */
    private User dtoTOUser(UserDto userDto) {
        return this.modelMapper.map(userDto, User.class);
    }

    /**
     * Map User entity to UserDto.
     */
    private UserDto userToDto(User user) {
        return this.modelMapper.map(user, UserDto.class);
    }
}
