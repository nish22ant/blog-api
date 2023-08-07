package com.blog.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.api.entities.User;

/**
 * This interface represents a repository for User entities in the Blog API.
 *
 * @Author Nishant
 */
public interface UserRepo extends JpaRepository<User, Integer> {
}
