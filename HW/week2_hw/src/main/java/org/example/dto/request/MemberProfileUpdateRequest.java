package org.example.dto.request;


import org.example.enums.Part;

public record MemberProfileUpdateRequest(
        int generation,
        Part part
) { }
