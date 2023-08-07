package com.blog.api.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.api.entities.Comment;
import com.blog.api.entities.Post;
import com.blog.api.exceptions.ResourceNotFoundException;
import com.blog.api.payloads.CommentDto;
import com.blog.api.repositories.CommentRepo;
import com.blog.api.repositories.PostRepo;
import com.blog.api.services.CommentService;

/**
 * This class implements the CommentService interface and provides methods for managing Comment entities.
 *
 * @Author Nishant
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Create a new comment for a post.
     *
     * @param commentDto The CommentDto containing comment information.
     * @param postId The ID of the post to which the comment is added.
     * @return The created CommentDto.
     * @throws ResourceNotFoundException If the post with the specified ID is not found.
     */
    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));

        Comment comment = this.modelMapper.map(commentDto, Comment.class);

        comment.setPost(post);

        Comment saveComment = this.commentRepo.save(comment);

        return this.modelMapper.map(saveComment, CommentDto.class);
    }

    /**
     * Delete a comment by ID.
     *
     * @param commentId The ID of the comment to be deleted.
     * @throws ResourceNotFoundException If the comment with the specified ID is not found.
     */
    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepo.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", commentId));

        this.commentRepo.delete(comment);
    }
}
