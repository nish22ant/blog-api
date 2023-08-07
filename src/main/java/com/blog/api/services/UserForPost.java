package com.blog.api.services;

import com.blog.api.payloads.UserDto;

/**
 * This interface defines the service methods for managing user associations with posts in the Blog API.
 *
 * @Author Nishant
 */
public interface UserForPost {

    /**
     * Create a new user association with a post.
     *
     * @param userDto The UserDto containing user information.
     * @param postId The ID of the post to associate the user with.
     * @return The created UserDto.
     */
    UserDto createUserForPost(UserDto userDto, Integer postId);

    /**
     * Delete a user association from a post.
     *
     * @param userId The ID of the user to be disassociated from the post.
     */
    void deleteUserFromPost(Integer userId);
}
