package com.blog.api.services;

import java.util.List;

import com.blog.api.payloads.CategoryDto;

/**
 * This interface defines the service methods for managing Category entities in the Blog API.
 *
 * @Author Nishant
 */
public interface CategoryService {

    /**
     * Create a new category.
     *
     * @param categoryDto The CategoryDto containing category information.
     * @return The created CategoryDto.
     */
    CategoryDto createCategory(CategoryDto categoryDto);

    /**
     * Update an existing category.
     *
     * @param categoryDto The CategoryDto containing updated category information.
     * @param categoryId The ID of the category to be updated.
     * @return The updated CategoryDto.
     */
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    /**
     * Delete a category.
     *
     * @param categoryId The ID of the category to be deleted.
     */
    void deleteCategory(Integer categoryId);

    /**
     * Get category information by ID.
     *
     * @param categoryId The ID of the category.
     * @return The CategoryDto for the given ID.
     */
    CategoryDto getCategory(Integer categoryId);

    /**
     * Get a list of all categories.
     *
     * @return A list of CategoryDto objects.
     */
    List<CategoryDto> getCategories();
}
