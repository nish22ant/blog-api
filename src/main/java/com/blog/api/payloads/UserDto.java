package com.blog.api.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents a DTO (Data Transfer Object) for user information in the Blog API.
 *
 * @Author Nishant
 */
@NoArgsConstructor
@Data
public class UserDto {
    private int id;

    @NotEmpty
    @Size(min = 4, message = "Username must be greater than 4 characters")
    private String name;

    @Email(message = "Email address is not valid")
    private String email;

    @NotEmpty
    @Size(min = 3, max = 10, message = "Password must be between 3 and 10 characters")
    private String password;

    @NotEmpty
    private String about;
}
