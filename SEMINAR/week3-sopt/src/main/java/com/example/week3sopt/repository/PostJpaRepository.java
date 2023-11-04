package com.example.week3sopt.repository;

import com.example.week3sopt.domain.Member;
import com.example.week3sopt.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostJpaRepository extends JpaRepository<Post, Long> {

    //두 메소도 모두 같은 결과를 반환
    List<Post> findAllByMemberId(Long memberId);
    List<Post> findAllByMember(Member member);
}
