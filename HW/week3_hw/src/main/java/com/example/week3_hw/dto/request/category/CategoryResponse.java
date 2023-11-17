package com.example.week3_hw.dto.request.category;

import com.example.week3_hw.domain.Category;

public record CategoryResponse(
        Short id,
        String content
) {
    public static CategoryResponse of(Category category){
        return new CategoryResponse(
                category.getId(),
                category.getContent()
        );
    }
}
