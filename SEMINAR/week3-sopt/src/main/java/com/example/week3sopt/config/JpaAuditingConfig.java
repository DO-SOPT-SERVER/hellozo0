package com.example.week3sopt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing //Application.java에 어노테이션 직접적으로 쓰기보다, 따로 설정 클래스로 ...
public class JpaAuditingConfig {
}
