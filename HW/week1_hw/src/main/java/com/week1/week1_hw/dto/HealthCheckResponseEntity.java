package com.week1.week1_hw.dto;

import lombok.Getter;

@Getter
public class HealthCheckResponseEntity {
    private int code;
    private String status;
    private boolean success;

    public HealthCheckResponseEntity(int code, String status, boolean success) {
        this.code = code;
        this.status = status;
        this.success = success;
    }
}
