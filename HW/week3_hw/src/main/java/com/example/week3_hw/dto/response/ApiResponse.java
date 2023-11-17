package com.example.week3_hw.dto.response;

import com.example.week3_hw.constant.ErrorMessage;
import com.example.week3_hw.constant.SuccessMessage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {
    private final int status;
    private final String message;
    private T data;

    public static <T> ApiResponse<T> success(SuccessMessage successMessage, T data){
        return new ApiResponse<>(successMessage.getStatus().value(), successMessage.getMessage(), data);
    }

    public static <T> ApiResponse<T> success(SuccessMessage successMessage){
        return new ApiResponse<>(successMessage.getStatus().value(), successMessage.getMessage());
    }

    public static <T> ApiResponse<T> fail(ErrorMessage errorMessage){
        return new ApiResponse<>(errorMessage.getStatus().value(), errorMessage.getMessage());
    }


}