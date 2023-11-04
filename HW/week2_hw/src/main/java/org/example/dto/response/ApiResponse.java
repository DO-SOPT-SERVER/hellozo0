package org.example.dto.response;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.constant.ErrorMessage;
import org.example.constant.SuccessMessage;
import org.springframework.http.HttpStatus;

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
