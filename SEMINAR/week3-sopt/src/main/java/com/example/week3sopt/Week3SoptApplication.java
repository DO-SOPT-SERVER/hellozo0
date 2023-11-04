package com.example.week3sopt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableJpaAuditing //LocalTime 설정하면서 어노테이션 추가함
public class Week3SoptApplication {

	public static void main(String[] args) {
		SpringApplication.run(Week3SoptApplication.class, args);
	}

}
