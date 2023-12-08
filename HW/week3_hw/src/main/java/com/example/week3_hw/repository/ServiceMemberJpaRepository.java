package com.example.week3_hw.repository;

import com.example.week3_hw.domain.ServiceMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceMemberJpaRepository extends JpaRepository<ServiceMember, Long> {
    Optional<ServiceMember> findByNickname(String nickname);
}
