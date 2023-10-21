package com.week1.week1_hw.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


//[1] Getter를 쓰는 이유는 Restcontroller는 자바 객체를 JSON의 형태로 변형 시켜줄때 필요하기 때문이다
//[2] AllArgsConstructor private으로 설정함으로서 무분별한 객체 생성을 막는다.
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {
    private int code;
    private String status;
    private boolean success;

    public static <T>  ApiResponse<T> success(HttpStatus httpStatus) {
        return new ApiResponse(httpStatus.value(), httpStatus.name(), true);
    }

    public static <T>  ApiResponse<T> error(HttpStatus httpStatus) {
        return new ApiResponse(httpStatus.value(), httpStatus.name(), false);
    }
}
