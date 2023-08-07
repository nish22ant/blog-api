package com.blog.api.services;

import com.blog.api.payloads.CommentDto;

/**
 * This interface defines the service methods for managing Comment entities in the Blog API.
 *
 * @Author Nishant
 */
public interface CommentService {

    /**
     * Create a new comment for a post.
     *
     * @param commentDto The CommentDto containing comment information.
     * @param postId The ID of the post for which the comment is created.
     * @return The created CommentDto.
     */
    CommentDto createComment(CommentDto commentDto, Integer postId);

    /**
     * Delete a comment.
     *
     * @param commentId The ID of the comment to be deleted.
     */
    void deleteComment(Integer commentId);
}
