# Blog API Documentation

This is the documentation for the Blog API, a backend service for managing blog posts, comments, categories, and users.

## Table of Contents

- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Endpoints](#endpoints)
- [Services](#services)
- [Exceptions](#exceptions)
- [Entities](#entities)
- [Payloads](#payloads)
- [Repositories](#repositories)

## Introduction

The Blog API is a Spring Boot-based backend service that provides various endpoints for managing a blog system. It allows users to create, read, update, and delete blog posts, manage comments, handle user information, and organize posts into categories.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Lombok
- ModelMapper

## Getting Started

1. Clone the repository: `git clone https://github.com/yourusername/blog-api.git`
2. Configure your database connection in `application.properties` file.
3. Run the application: `./mvnw spring-boot:run`

## Endpoints

The API provides the following endpoints:

- `/api/categories`: Manage blog categories.
- `/api/posts`: Manage blog posts.
- `/api/users`: Manage users.
- `/api/comments`: Manage comments.

Detailed endpoint documentation can be found in your API documentation tool (e.g., Swagger UI).

## Services

The following services are available:

- `CategoryService`: Manage blog categories.
- `PostService`: Manage blog posts.
- `UserService`: Manage users.
- `CommentService`: Manage comments.
- `FileService`: Manage file uploads.

## Exceptions

Custom exceptions are used to handle different scenarios:

- `ResourceNotFoundException`: Thrown when a requested resource is not found.
- `ApiResponse`: A response model for API responses.

## Entities

The following entities are used to represent data:

- `Category`: Represents a blog category.
- `Post`: Represents a blog post.
- `User`: Represents a user.
- `Comment`: Represents a comment on a blog post.

## Payloads

Payload classes are used to transfer data between the client and the API:

- `CategoryDto`: Represents category data.
- `PostDto`: Represents post data.
- `UserDto`: Represents user data.
- `CommentDto`: Represents comment data.

## Repositories

The following repositories manage data storage:

- `CategoryRepo`: Manages category data.
- `PostRepo`: Manages post data.
- `UserRepo`: Manages user data.
- `CommentRepo`: Manages comment data.
