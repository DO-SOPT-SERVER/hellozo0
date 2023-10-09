package com.week1.week1_hw.dto;

public class HealthCheckResponseEntity {
    private Integer code;
    private String status;
    private Boolean success;

    public HealthCheckResponseEntity(Integer code, String status, Boolean success) {
        this.code = code;
        this.status = status;
        this.success = success;
    }
}
