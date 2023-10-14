package com.example.week2sopt.dto.request;

import com.example.week2sopt.entity.SOPT;
import lombok.Data;


public record MemberCreateRequest(
        String name,
        String nickname,
        int age,
        SOPT sopt
) {
//    private String name;
//    private String nickname;
//    private int age;
//    private SOPT sopt;
}
