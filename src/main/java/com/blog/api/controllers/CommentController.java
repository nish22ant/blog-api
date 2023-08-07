package com.blog.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.api.exceptions.ApiResponse;
import com.blog.api.payloads.CommentDto;
import com.blog.api.services.CommentService;

/**
 * This class represents the REST controller for managing comments in the Blog API.
 * It provides endpoints for creating and deleting comments on blog posts.
 *
 * @Author Nishant
 */
@RestController
@RequestMapping("/api/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * Endpoint for creating a new comment on a specific blog post.
     *
     * @param comment The comment data to be created.
     * @param postId  The ID of the blog post on which the comment is posted.
     * @return A ResponseEntity containing the created CommentDto and HTTP status.
     */
    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment, @PathVariable Integer postId) {
        CommentDto createdComment = this.commentService.createComment(comment, postId);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    /**
     * Endpoint for deleting a comment.
     *
     * @param commentId The ID of the comment to be deleted.
     * @return A ResponseEntity with a success message and HTTP status.
     */
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId) {
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<>(new ApiResponse("Comment deleted successfully !!", true), HttpStatus.OK);
    }
}
