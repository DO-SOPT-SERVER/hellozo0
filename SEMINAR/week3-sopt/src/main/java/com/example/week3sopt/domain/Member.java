package com.example.week3sopt.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity{

    @Id //field가 식별자 임을 명시해주는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Database에 id를 어떻게 생성할 지 생성 전략을 나타내는 어노테이션
    private Long id;
    private String nickname;
    private String name;
    private int age;


    @Embedded //공통적으로 관리할 수 있는 필드들은 한 객체의 속성으로 보고, 객체로 관리해주는 것
    private SOPT sopt; //@Embedded 로 들어갈 class에는 아래 코드와 같이 @Embeddable 을 붙여주셔야 합니다.

    @Builder
    public Member(String name, String nickname, int age, SOPT sopt) {
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.sopt = sopt;
    }

    //회원 정보 수정
    public void updateSOPT(SOPT sopt){
        this.sopt = sopt;
    }




}