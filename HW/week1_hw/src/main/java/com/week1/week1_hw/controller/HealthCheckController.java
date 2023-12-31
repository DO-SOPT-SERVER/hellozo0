package com.week1.week1_hw.controller;

import com.week1.week1_hw.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @GetMapping("/v1")
    public Map<String, String> healthCheckV1() {
        Map<String,String> response = new HashMap<>();
        response.put("status", "OK");
        response.put("success", "true");
        return response;
    }

    @GetMapping("/v2")
    public ResponseEntity<String> healthCheckV2() {
        return ResponseEntity.ok("OK");
    }
    @GetMapping("/v3")
    public String healthCheckV3() {
        return "OK";
    }

    @GetMapping("/v4")
    public ResponseEntity<Map<String, String>> healthCheckV4() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return ResponseEntity.ok(response);
    }

//    @GetMapping("/v5")
//    public ResponseEntity<HealthCheckResponse> healthCheckV5() {
//        return ResponseEntity.ok(new HealthCheckResponse());
//    }

    @GetMapping("/v6")
    public ApiResponse<ApiResponse> healthCheckV6() {
        return ApiResponse.success(HttpStatus.OK);  //	OK(200, Series.SUCCESSFUL, "OK")
    }


}
