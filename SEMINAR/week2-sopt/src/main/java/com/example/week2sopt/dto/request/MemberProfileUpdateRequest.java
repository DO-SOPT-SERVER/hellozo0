package com.example.week2sopt.dto.request;

import com.example.week2sopt.enums.Part;
import lombok.Data;

@Data
public class MemberProfileUpdateRequest {
    private int generation;
    private Part part;
}
