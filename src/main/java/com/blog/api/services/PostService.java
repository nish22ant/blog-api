package com.blog.api.services;

import java.util.List;

import com.blog.api.payloads.PostDto;
import com.blog.api.payloads.PostResponse;

/**
 * This interface defines the service methods for managing Post entities in the Blog API.
 *
 * @Author Nishant
 */
public interface PostService {

    /**
     * Create a new post.
     *
     * @param post The PostDto containing post information.
     * @param userId The ID of the user who is creating the post.
     * @param categoryId The ID of the category for the post.
     * @return The created PostDto.
     */
    PostDto createPost(PostDto post, Integer userId, Integer categoryId);

    /**
     * Update an existing post.
     *
     * @param post The PostDto containing updated post information.
     * @param postId The ID of the post to be updated.
     * @return The updated PostDto.
     */
    PostDto updatePost(PostDto post, Integer postId);

    /**
     * Delete a post.
     *
     * @param postId The ID of the post to be deleted.
     */
    void deletePost(Integer postId);

    /**
     * Get paginated list of all posts.
     *
     * @param pageNumber The page number for pagination.
     * @param pageSize The number of items per page.
     * @param sortBy The field to sort by.
     * @return A PostResponse containing paginated post information.
     */
    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy);

    /**
     * Get post information by ID.
     *
     * @param postId The ID of the post.
     * @return The PostDto for the given ID.
     */
    PostDto getPostById(Integer postId);

    /**
     * Get a list of posts by category.
     *
     * @param categoryId The ID of the category.
     * @return A list of PostDto objects.
     */
    List<PostDto> getPostsByCategory(Integer categoryId);

    /**
     * Get a list of posts by user.
     *
     * @param userId The ID of the user.
     * @return A list of PostDto objects.
     */
    List<PostDto> getPostsByUser(Integer userId);

    /**
     * Search posts by keyword.
     *
     * @param keyword The search keyword.
     * @return A list of PostDto objects matching the search.
     */
    List<PostDto> searchPosts(String keyword);
}
