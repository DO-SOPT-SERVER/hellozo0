package com.example.week3sopt.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class) //파라미터를 잘 못 넣거나 하면 이렇게 응답을 보내겠다! 하는 용도
    public ResponseEntity<Void> handleIllegalArgumentException(final IllegalArgumentException e) {
        return ResponseEntity.badRequest().build(); //즉 400으로 보내겠따~
    }

    @ExceptionHandler(BusinessException.class) //Custom Exception 정의한것 처리 -> 이후 서비스에서 Bad Request 내려주고 싶은 상황에 해당 Exception을 활용
    public ResponseEntity<Void> handleBusinessException(BusinessException e) {
        return ResponseEntity.badRequest().build();
    }

}

/*
대표적으로 발생할 수 있는 Exception들
1. `IllegalArgumentException`
2. `IllegalStateException`

그 외에도 …
1. **`FileNotFoundException`**
2. **`NoSuchBeanDefinitionException`**
3. **`HttpMessageNotReadableException`**
4. **`MethodArgumentNotValidException`**


IllegalArgumentException 도 서비스의 어떤 부분에서 발생했냐에 따라서 다르게 응답을 주고 싶은 상황이 있을 수 있을 것 이다.
그래서 생각할 수 있는 것이 바로 Custom Exception을 정의하는 것!
 */