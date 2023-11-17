package com.example.week3_hw.dto.request.member;

import com.example.week3_hw.enums.Part;

public record MemberProfileUpdateRequest(
        int generation,
        Part part
) { }
