package com.example.week3_hw.dto.request.member;


import com.example.week3_hw.domain.SOPT;

public record MemberCreateRequest(
        String name,
        String nickname,
        int age,
        SOPT sopt
) {}

