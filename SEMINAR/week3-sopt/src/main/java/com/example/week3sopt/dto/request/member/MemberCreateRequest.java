package com.example.week3sopt.dto.request.member;


import com.example.week3sopt.domain.SOPT;

public record MemberCreateRequest(
        String name,
        String nickname,
        int age,
        SOPT sopt
) {}

