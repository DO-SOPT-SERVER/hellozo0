package org.example.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.constant.ErrorMessage;
import org.example.domain.SOPT;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.domain.Member;
import org.example.dto.request.MemberCreateRequest;
import org.example.dto.request.MemberGetResponse;
import org.example.dto.request.MemberProfileUpdateRequest;
import org.example.repository.MemberJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberJpaRepository memberJpaRepository; //의존성 주입 - Repository의 기능을 쓸꺼다~


    //  특정 사용자 정보 단건 조회 V1 용 Service
    public MemberGetResponse getMemberByIdV1(Long id) {
        Member member = memberJpaRepository.findById(id).get(); // JPA에서 자체 내장 되어 있는 Id를 기준으로 찾아주는 내장함수?를 사용해서 member 찾기
        return MemberGetResponse.of(member);
    }

    //  특정 사용자 정보 단건 조회 V2 용 Service
    public MemberGetResponse getMemberByIdV2(Long id) {
        return MemberGetResponse.of(memberJpaRepository.findById(id).orElseThrow( //만약에 회원이 없을 경우의 에러 처리를 해주는 ..함수..?!
                () -> new EntityNotFoundException(ErrorMessage.NOT_FOUND_MEMBER_EXCEPTION.getMessage())));
    }

    //  특정 사용자 정보 단건 조회 V3 용 Service
    public MemberGetResponse getMemberByIdV3(Long id) {
        return MemberGetResponse.of(memberJpaRepository.findByIdOrThrow(id));
        // JPA Repository에 우리가 자체로 만든 에러를 해결해주는 함수?를 만들었고. Service에서는 만든것을 그냥 불러오는것
        // V2랑 실행은 똑같이 돌아감
    }

    // 전체목록 조회용 Service
    public List<MemberGetResponse> getMembers() {
        return memberJpaRepository.findAll()
                .stream()// 엔티티를 DTO의 형태로 내보내준다.
                .map(MemberGetResponse::of) //매핑을 해주겠다. 이걸 사용해서 매핑 하겠다.  - MemberGetResponse의  DTO 형태로 바꿔서
                .collect(Collectors.toList()); //List 타입으로 변경하겠다.
    }


    //생성 Service
    @Transactional
    public void create(MemberCreateRequest request) {
//        Member member =  memberJpaRepository.save(Member.builder() //save가 리턴 값이 있게 받아올 수도 있
//                .name(request.getName())
//                .nickname(request.getNickname())
//                .age(request.getAge())
//                .sopt(request.getSopt())
//                .build());
//        return member.getId().toString();

        //class를 record로 리팩토링을 하면 getName이렇게 안 쓰고 name() 바로 가져올 수 있따.
        Member member =  memberJpaRepository.save(Member.builder() //save가 리턴 값이 있게 받아올 수도 있음
                .name(request.name())
                .nickname(request.nickname())
                .age(request.age())
                .sopt(request.sopt())
                .build());
    }

    //수정 Service
    @Transactional
    public void updateSOPT(Long memberId, MemberProfileUpdateRequest request) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        member.updateSOPT(new SOPT(request.generation(), request.part()));
    }

    //삭제 Service
    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        memberJpaRepository.delete(member);
    }
}
