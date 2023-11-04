package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.constant.SuccessMessage;
import org.example.dto.request.MemberCreateRequest;
import org.example.dto.request.MemberGetResponse;
import org.example.dto.request.MemberProfileUpdateRequest;
import org.example.dto.response.ApiResponse;
import org.example.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 특정 사용자 정보 단건 조회 V1
    @GetMapping("/{memberId}")
    public ApiResponse<MemberGetResponse> getMemberProfileV1(@PathVariable Long memberId) {
        return ApiResponse.success(SuccessMessage.SEARCH_MEMBER_SUCCESS, memberService.getMemberByIdV2(memberId));
//        return ResponseEntity.ok(memberService.getMemberByIdV2(memberId));
    }

    //consumes는 클라이언트가 서버에게 보내는 데이터 타입을 명시한다.
    //produces는 서버가 클라이언트에게 반환하는 데이터 타입을 명시한다.
    // 특정 사용자 정보 단건 조회 V2
//    @GetMapping(value = "/{memberId}/v2", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/{memberId}/v2")
    public ApiResponse<MemberGetResponse> getMemberProfileV2(@PathVariable Long memberId) {
        return ApiResponse.success(SuccessMessage.SEARCH_MEMBER_SUCCESS, memberService.getMemberByIdV2(memberId));
//        return ResponseEntity.ok(memberService.getMemberByIdV2(memberId));
    }
    // 특정 사용자 정보 단건 조회 V3
//    @GetMapping(value = "/{memberId}/v3", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/{memberId}/v3")
    public ApiResponse<MemberGetResponse> getMemberProfileV3(@PathVariable Long memberId) {
        return ApiResponse.success(SuccessMessage.SEARCH_MEMBER_SUCCESS, memberService.getMemberByIdV3(memberId));
//        return ResponseEntity.ok(memberService.getMemberByIdV3(memberId));
    }


    // 목록 조회
    @GetMapping
    public ApiResponse<List<MemberGetResponse>> getMembersProfile() {
        return ApiResponse.success(SuccessMessage.SEARCH_ALL_MEMBER_SUCCESS, memberService.getMembers());
//        return ResponseEntity.ok(memberService.getMembers());
    }

    // 생성
    @PostMapping
    public ApiResponse<Void> createMember(@RequestBody MemberCreateRequest request) {
        memberService.create(request);
//        URI location =  URI.create("api/member/" + memberService.create(request)); //api/members 추가
        return ApiResponse.success(SuccessMessage.CREATE_MEMBER_SUCCESS);
//        return ResponseEntity.created(location).build();
    }

    // 수정
    @PatchMapping("/{memberId}")
    public ApiResponse<Void> updateMemberSoptInfo(@PathVariable Long memberId, @RequestBody MemberProfileUpdateRequest request) {
        memberService.updateSOPT(memberId, request);
        return ApiResponse.success(SuccessMessage.UPDATE_MEMBER_SUCCESS);
//        return ResponseEntity.noContent().build();
    }

    // 삭제
    @DeleteMapping("/{memberId}")
    public ApiResponse deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ApiResponse.success(SuccessMessage.DELETE_MEMBER_SUCCESS);
//        return ResponseEntity.noContent().build();
    }
}
