package com.example.week3sopt.controller;


import com.example.week3sopt.dto.request.member.MemberGetResponse;
import com.example.week3sopt.dto.request.post.PostCreateRequest;
import com.example.week3sopt.dto.request.post.PostGetResponse;
import com.example.week3sopt.dto.request.post.PostUpdateRequest;
import com.example.week3sopt.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private static final String CUSTOM_AUTH_ID = "X-Auth-Id"; //인증 인가와관련된 것인데.. 추후에 배울 예정이지만 더 알아보면 좋음 2주차때 Header에 유저 관련된 정보를 넣는다고 햇음 그거 활용
    private final PostService postService;

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestHeader(CUSTOM_AUTH_ID) Long memberId,
                                           @RequestBody PostCreateRequest request){
        String postId = postService.create(request, memberId);
        URI location = URI.create("/api/posts/" + postId);
        return ResponseEntity.created(location).build();
    }


    @GetMapping("{postId}") //원하는 post보기
    public ResponseEntity<PostGetResponse> getPostById(@PathVariable Long postId){
        return ResponseEntity.ok(postService.getById(postId));
    }

    @GetMapping //특정 멤버가 쓴 포스트 보기
    public ResponseEntity<List<PostGetResponse>> getPosts(@RequestHeader(CUSTOM_AUTH_ID) Long memberId) {
        return ResponseEntity.ok(postService.getPosts(memberId));
    }

    @PatchMapping("{postId}")
    public ResponseEntity<Void> updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequest request) {
        postService.editContent(postId, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deleteById(postId);
        return ResponseEntity.noContent().build();
    }



}
