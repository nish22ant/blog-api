package com.blog.api.payloads;

import lombok.Data;

/**
 * This class represents a DTO (Data Transfer Object) for comment information in the Blog API.
 *
 * @Author Nishant
 */
@Data
public class CommentDto {
    private int id;
    private String content;
}
