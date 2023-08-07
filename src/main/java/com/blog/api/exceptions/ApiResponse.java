package com.blog.api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents an API response in the Blog API.
 *
 * @Author Nishant
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiResponse {
    private String message;
    private boolean success;
}
