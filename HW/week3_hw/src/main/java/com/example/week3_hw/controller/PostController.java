package com.example.week3_hw.controller;


import com.example.week3_hw.constant.SuccessMessage;
import com.example.week3_hw.dto.request.post.PostCreateRequest;
import com.example.week3_hw.dto.request.post.PostGetResponse;
import com.example.week3_hw.dto.request.post.PostUpdateRequest;
import com.example.week3_hw.dto.response.ApiResponse;
import com.example.week3_hw.service.PostService;
import lombok.RequiredArgsConstructor;
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
    public ApiResponse createPost(@RequestHeader(CUSTOM_AUTH_ID) Long memberId,
                                           @RequestBody PostCreateRequest request){
        postService.create(request, memberId);
        return ApiResponse.success(SuccessMessage.CREATE_POST_SUCCESS);

    }

    @GetMapping("{postId}") //원하는 post보기
    public ApiResponse getPostById(@PathVariable Long postId){
        return ApiResponse.success(SuccessMessage.SEARCH_POST_SUCCESS,postService.getByPostId(postId));
    }

    @GetMapping //특정 멤버가 쓴 포스트 보기
    public ApiResponse getPosts(@RequestHeader(CUSTOM_AUTH_ID) Long memberId) {
        return ApiResponse.success(SuccessMessage.SEARCH_POST_BY_MEMBER_SUCCESS, postService.getByMemberId(memberId));
    }

    @PatchMapping("{postId}")
    public ApiResponse updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequest request) {
        postService.editContent(postId, request);
        return ApiResponse.success(SuccessMessage.UPDATE_POST_SUCCESS);
    }

    @DeleteMapping("{postId}")
    public ApiResponse deletePost(@PathVariable Long postId) {
        postService.deleteById(postId);
        return ApiResponse.success(SuccessMessage.DELETE_POST_SUCCESS);
    }



}
