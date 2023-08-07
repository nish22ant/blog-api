package com.blog.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.api.entities.Category;

/**
 * This interface represents a repository for Category entities in the Blog API.
 *
 * @Author Nishant
 */
public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
