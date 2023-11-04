package com.example.week3sopt.dto.request.member;


import com.example.week3sopt.enums.Part;

public record MemberProfileUpdateRequest(
        int generation,
        Part part
) { }
