package com.example.week3_hw.dto.request.post;

import com.example.week3_hw.domain.Post;

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

