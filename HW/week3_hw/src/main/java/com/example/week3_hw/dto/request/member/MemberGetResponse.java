package com.example.week3_hw.dto.request.member;


import com.example.week3_hw.domain.Member;
import com.example.week3_hw.domain.SOPT;

public record MemberGetResponse(
        String name,
        String nickname,
        int age,
        SOPT soptInfo
) {
    public static MemberGetResponse of(Member member) {
        return new MemberGetResponse(
                member.getName(),
                member.getNickname(),
                member.getAge(),
                member.getSopt()
        );
    }
}
