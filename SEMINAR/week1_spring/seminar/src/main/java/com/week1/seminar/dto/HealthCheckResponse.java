package com.week1.seminar.dto;

import lombok.Getter;

@Getter //GETTER 왜 써야하는지 더 알아보기
public class HealthCheckResponse {

    private static final String STATUS = "OK";
    private String status;

    public HealthCheckResponse() {
        this.status = STATUS;
    }
}
