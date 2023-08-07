package com.blog.api.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents a DTO (Data Transfer Object) for category information in the Blog API.
 *
 * @Author Nishant
 */
@NoArgsConstructor
@Data
public class CategoryDto {

    private Integer categoryId;

    @NotBlank
    @Size(min = 4)
    private String categoryTitle;

    @NotBlank
    @Size(min = 10)
    private String categoryDescription;
}
