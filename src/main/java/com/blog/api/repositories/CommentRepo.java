package com.blog.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.api.entities.Comment;

/**
 * This interface represents a repository for Comment entities in the Blog API.
 *
 * @Author Nishant
 */
public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
