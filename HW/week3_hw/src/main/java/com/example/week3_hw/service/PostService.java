package com.example.week3_hw.service;


import com.example.week3_hw.domain.Category;
import com.example.week3_hw.domain.Member;
import com.example.week3_hw.domain.Post;
import com.example.week3_hw.dto.request.post.PostCreateRequest;
import com.example.week3_hw.dto.request.post.PostGetResponse;
import com.example.week3_hw.dto.request.post.PostUpdateRequest;
import com.example.week3_hw.repository.MemberJpaRepository;
import com.example.week3_hw.repository.PostJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostJpaRepository postJpaRepository;
    private final MemberJpaRepository memberJpaRepository;
    private final CategoryService categoryService;

    @Transactional
    public void create(PostCreateRequest request, Long memberId) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        Post post = postJpaRepository.save(
                Post.builder()
                        .title(request.title())
                        .content(request.content())
                        .member(member)
                        .build());
//        return post.getPostId().toString();
    }

    public List<PostGetResponse> getByMemberId(Long memberId){
        return postJpaRepository.findAllByMemberId(memberId)
                .stream()
                .map(post -> PostGetResponse.of(post))
                .toList();
//                .map(PostGetResponse::of)
//                .collect(Collectors.toList());
    }

    public PostGetResponse getByPostId(Long postId){
        Post post = postJpaRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
        return PostGetResponse.of(post);
    }

    @Transactional
    public void editContent(Long postId, PostUpdateRequest request) {
        Post post = postJpaRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
        post.updateContent(request.content());
    }

    @Transactional
    public void deleteById(Long postId) {
        Post post = postJpaRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
        postJpaRepository.delete(post);
    }

    private Category getCategoryByPost(Post post) {
        return categoryService.getByCategoryId(post.getCategoryId());
    }


}
