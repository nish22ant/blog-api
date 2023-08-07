package com.blog.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.api.exceptions.ApiResponse;
import com.blog.api.payloads.CategoryDto;
import com.blog.api.services.CategoryService;

/**
 * This class represents the REST controller for managing categories in the Blog API.
 * It provides endpoints for creating, updating, deleting, and retrieving categories.
 *
 * @Author Nishant
 */
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * Endpoint for creating a new category.
     *
     * @param categoryDto The category data to be created.
     * @return A ResponseEntity containing the created CategoryDto and HTTP status.
     */
    @PostMapping("")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto createdCategoryDto = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createdCategoryDto, HttpStatus.CREATED);
    }

    /**
     * Endpoint for updating an existing category.
     *
     * @param categoryDto The updated category data.
     * @param catId       The ID of the category to be updated.
     * @return A ResponseEntity containing the updated CategoryDto and HTTP status.
     */
    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(
            @Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer catId) {
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, catId);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    /**
     * Endpoint for deleting a category.
     *
     * @param catId The ID of the category to be deleted.
     * @return A ResponseEntity with a success message and HTTP status.
     */
    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId) {
        this.categoryService.deleteCategory(catId);
        return new ResponseEntity<>(new ApiResponse("Category is deleted successfully !!", false), HttpStatus.OK);
    }

    /**
     * Endpoint for retrieving a category by ID.
     *
     * @param catId The ID of the category to be retrieved.
     * @return A ResponseEntity containing the retrieved CategoryDto and HTTP status.
     */
    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId) {
        CategoryDto categoryDto = this.categoryService.getCategory(catId);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    /**
     * Endpoint for retrieving all categories.
     *
     * @return A ResponseEntity containing a list of CategoryDto objects and HTTP status.
     */
    @GetMapping("")
    public ResponseEntity<List<CategoryDto>> getCategories() {
        List<CategoryDto> categories = this.categoryService.getCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
