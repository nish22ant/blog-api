package com.blog.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.api.exceptions.ApiResponse;
import com.blog.api.payloads.UserDto;
import com.blog.api.services.UserService;

/**
 * This class represents the REST controller for managing users in the Blog API.
 * It provides endpoints for creating, updating, deleting, and retrieving user information.
 *
 * @Author Nishant
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Endpoint for creating a new user.
     *
     * @param userDto The user data to be created.
     * @return A ResponseEntity containing the created UserDto and HTTP status.
     */
    @PostMapping("")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createdUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    /**
     * Endpoint for updating an existing user.
     *
     * @param userDto The updated user data.
     * @param userId  The ID of the user to be updated.
     * @return A ResponseEntity with the updated UserDto and HTTP status.
     */
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(
            @Valid @RequestBody UserDto userDto, @PathVariable Integer userId) {
        this.userService.updateUser(userDto, userId);
        return ResponseEntity.ok(userDto);
    }

    /**
     * Endpoint for deleting a user.
     *
     * @param userId The ID of the user to be deleted.
     * @return A ResponseEntity with a success message and HTTP status.
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId) {
        this.userService.deteleUser(userId);
        return new ResponseEntity<>(new ApiResponse("User deleted successfully", true), HttpStatus.OK);
    }

    /**
     * Endpoint for fetching information about all users.
     *
     * @return A ResponseEntity containing a list of UserDto objects and HTTP status.
     */
    @GetMapping("")
    public ResponseEntity<List<UserDto>> getAllUser() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    /**
     * Endpoint for fetching information about a single user by ID.
     *
     * @param userId The ID of the user to be retrieved.
     * @return A ResponseEntity containing the retrieved UserDto and HTTP status.
     */
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }
}
