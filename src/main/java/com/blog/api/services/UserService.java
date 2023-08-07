package com.blog.api.services;

import java.util.List;

import com.blog.api.payloads.UserDto;

/**
 * This interface defines the service methods for managing User entities in the Blog API.
 *
 * @Author Nishant
 */
public interface UserService {

    /**
     * Create a new user.
     *
     * @param user The UserDto containing user information.
     * @return The created UserDto.
     */
    UserDto createUser(UserDto user);

    /**
     * Update an existing user.
     *
     * @param user The UserDto containing updated user information.
     * @param userId The ID of the user to be updated.
     * @return The updated UserDto.
     */
    UserDto updateUser(UserDto user, Integer userId);

    /**
     * Get user information by ID.
     *
     * @param userId The ID of the user.
     * @return The UserDto for the given ID.
     */
    UserDto getUserById(Integer userId);

    /**
     * Get a list of all users.
     *
     * @return A list of UserDto objects.
     */
    List<UserDto> getAllUsers();

    /**
     * Delete a user.
     *
     * @param userId The ID of the user to be deleted.
     */
    void deteleUser(Integer userId);
}
