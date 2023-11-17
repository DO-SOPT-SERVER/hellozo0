package com.example.week3_hw.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum SuccessMessage {

    CREATE_MEMBER_SUCCESS(HttpStatus.CREATED, "회원을 생성했습니다."),
    SEARCH_ALL_MEMBER_SUCCESS(HttpStatus.OK, "모든 회원을 조회했습니다."),
    SEARCH_MEMBER_SUCCESS(HttpStatus.OK, "회원을 조회했습니다."),
    UPDATE_MEMBER_SUCCESS(HttpStatus.OK, "회원 정보를 업데이트했습니다."),
    DELETE_MEMBER_SUCCESS(HttpStatus.NO_CONTENT, "회원을 삭제했습니다."),

    CREATE_POST_SUCCESS(HttpStatus.CREATED, "게시물을 생성했습니다."),
    SEARCH_POST_SUCCESS(HttpStatus.OK, "게시물을 조회했습니다."),
    SEARCH_POST_BY_MEMBER_SUCCESS(HttpStatus.CREATED, "게시물을 조회했습니다."),
    UPDATE_POST_SUCCESS(HttpStatus.OK, "게시글을 업데이트했습니다."),
    DELETE_POST_SUCCESS(HttpStatus.NO_CONTENT, "게시글을 삭제했습니다.");

    private final HttpStatus status;
    private final String message;

}