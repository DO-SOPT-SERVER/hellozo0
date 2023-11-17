package org.example.dto.request;


import org.example.domain.SOPT;


public record MemberCreateRequest(
        String name,
        String nickname,
        int age,
        SOPT sopt
) {}

