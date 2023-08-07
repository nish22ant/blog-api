package com.blog.api.payloads;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class represents a response DTO for paginated post information in the Blog API.
 *
 * @Author Nishant
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostResponse {
    private List<PostDto> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean lastPage;
}
