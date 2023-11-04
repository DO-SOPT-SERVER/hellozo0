package com.example.week3sopt.dto.request.post;

import com.example.week3sopt.domain.Post;

public record PostGetResponse(
        Long postId,
        String title,
        String content
) {
    public static PostGetResponse of(Post post){
        return new PostGetResponse(
                post.getPostId(),
                post.getTitle(),
                post.getContent()
        );
    }
}

