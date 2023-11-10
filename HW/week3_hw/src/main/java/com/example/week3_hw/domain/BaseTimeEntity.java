package com.example.week3_hw.domain;


import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass //슈퍼클래스
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity { //abstract붙으면 추상 클래스


    @CreatedDate //자주 쓰는...거 어노테이션으로 쓸 수 있도록...머...
    private LocalDateTime creatdAt; //생성시각 ,기본값으로 LocaDateTime.now() 현재시간으로 초기화를 CreateDate어노테이션이 해줌

    @LastModifiedDate
    private LocalDateTime updateAt; //수정시각

}
