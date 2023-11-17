package com.example.week3_hw.dto.request.post;

public record PostCreateRequest(
        String title,
        String content
) {
}