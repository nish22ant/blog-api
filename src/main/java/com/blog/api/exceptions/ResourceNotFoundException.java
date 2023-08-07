package com.blog.api.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * This exception is thrown when a resource is not found in the Blog API.
 *
 * @Author Nishant
 */
@SuppressWarnings("serial")
@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
    String resourceName;
    String fieldName;
    long fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
