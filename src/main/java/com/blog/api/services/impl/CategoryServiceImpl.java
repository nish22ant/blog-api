package com.blog.api.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.api.entities.Category;
import com.blog.api.exceptions.ResourceNotFoundException;
import com.blog.api.payloads.CategoryDto;
import com.blog.api.repositories.CategoryRepo;
import com.blog.api.services.CategoryService;

/**
 * This class implements the CategoryService interface and provides methods for managing Category entities.
 *
 * @Author Nishant
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Create a new category.
     *
     * @param categoryDto The CategoryDto containing category information.
     * @return The created CategoryDto.
     */
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat = this.modelMapper.map(categoryDto, Category.class);
        Category addedCat = this.categoryRepo.save(cat);

        return this.modelMapper.map(addedCat, CategoryDto.class);
    }

    /**
     * Update an existing category.
     *
     * @param categoryDto The CategoryDto containing updated category information.
     * @param categoryId The ID of the category to be updated.
     * @return The updated CategoryDto.
     * @throws ResourceNotFoundException If the category with the specified ID is not found.
     */
    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));

        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCategoryDescription(categoryDto.getCategoryDescription());

        Category updatedcat = this.categoryRepo.save(cat);

        return this.modelMapper.map(updatedcat, CategoryDto.class);
    }

    /**
     * Delete a category by ID.
     *
     * @param categoryId The ID of the category to be deleted.
     * @throws ResourceNotFoundException If the category with the specified ID is not found.
     */
    @Override
    public void deleteCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));
        this.categoryRepo.delete(cat);
    }

    /**
     * Get category information by ID.
     *
     * @param categoryId The ID of the category.
     * @return The CategoryDto for the given ID.
     * @throws ResourceNotFoundException If the category with the specified ID is not found.
     */
    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));
        return this.modelMapper.map(cat, CategoryDto.class);
    }

    /**
     * Get a list of all categories.
     *
     * @return A list of CategoryDto objects.
     */
    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDto> catDtos = categories.stream().map((cat) -> this.modelMapper.map(cat, CategoryDto.class))
                .collect(Collectors.toList());
        return catDtos;
    }
}
