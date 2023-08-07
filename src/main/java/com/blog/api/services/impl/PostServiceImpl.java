package com.blog.api.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.blog.api.entities.Category;
import com.blog.api.entities.Post;
import com.blog.api.entities.User;
import com.blog.api.exceptions.ResourceNotFoundException;
import com.blog.api.payloads.PostDto;
import com.blog.api.payloads.PostResponse;
import com.blog.api.repositories.CategoryRepo;
import com.blog.api.repositories.PostRepo;
import com.blog.api.repositories.UserRepo;
import com.blog.api.services.PostService;

/**
 * Implementation of the PostService interface for managing blog posts.
 * @Author Nishant
 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    /**
     * Create a new post.
     */
    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        // Retrieve user and category by their IDs
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user", "user id", userId));
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category id", categoryId));

        // Map PostDto to Post entity and set necessary attributes
        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        // Save the new post and return the mapped PostDto
        Post newPost = this.postRepo.save(post);
        return this.modelMapper.map(newPost, PostDto.class);
    }

    /**
     * Update an existing post by ID.
     */
    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        // Retrieve the existing post by its ID
        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));

        // Update post attributes and save
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());
        Post updatedPost = this.postRepo.save(post);

        // Return the updated PostDto
        return this.modelMapper.map(updatedPost, PostDto.class);
    }

    /**
     * Delete a post by ID.
     */
    @Override
    public void deletePost(Integer postId) {
        // Retrieve and delete the post by its ID
        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));
        this.postRepo.delete(post);
    }

    /**
     * Get a paginated list of all posts.
     */
    @Override
    public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy) {
        // Create pageable object for pagination and sorting
        Pageable p = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());

        // Retrieve page of posts from the repository
        Page<Post> pagePost = this.postRepo.findAll(p);
        List<Post> allPosts = pagePost.getContent();

        // Map posts to PostDto and create a PostResponse object
        List<PostDto> postDto = allPosts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();

        // Set values for the PostResponse object
        postResponse.setContent(postDto);
        postResponse.setPageNumber(pagePost.getNumber());
        postResponse.setPageSize(pagePost.getSize());
        postResponse.setTotalElements(pagePost.getTotalElements());
        postResponse.setTotalPages(pagePost.getTotalPages());
        postResponse.setLastPage(pagePost.isLast());

        // Return the PostResponse
        return postResponse;
    }

    /**
     * Get a post by ID.
     */
    @Override
    public PostDto getPostById(Integer postId) {
        // Retrieve and map the post by its ID
        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("post", "post_id", postId));
        return this.modelMapper.map(post, PostDto.class);
    }

    /**
     * Get a list of posts by category ID.
     */
    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {
        // Retrieve and map posts by category ID
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("category", "category id", categoryId));
        List<Post> posts = this.postRepo.findByCategory(cat);
        return posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    /**
     * Get a list of posts by user ID.
     */
    @Override
    public List<PostDto> getPostsByUser(Integer userId) {
        // Retrieve and map posts by user ID
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        List<Post> posts = this.postRepo.findByUser(user);
        return posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    /**
     * Search for posts containing a specific keyword.
     */
    @Override
    public List<PostDto> searchPosts(String keyword) {
        List<Post> posts = this.postRepo.findByTitleContaining(keyword);
        return posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }
}
