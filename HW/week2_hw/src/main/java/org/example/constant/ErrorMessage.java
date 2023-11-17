package org.example.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorMessage {

    NOT_FOUND_MEMBER_EXCEPTION(HttpStatus.NOT_FOUND, "회원이 없습니다.");

    private final HttpStatus status;
    private final String message;
}
