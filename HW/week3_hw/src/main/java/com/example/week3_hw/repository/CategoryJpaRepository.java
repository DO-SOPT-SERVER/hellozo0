package com.example.week3_hw.repository;

import com.example.week3_hw.domain.Category;
import com.example.week3_hw.domain.Member;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

public interface CategoryJpaRepository extends JpaRepository<Category, Short> {
    default Category findByIdOrThrow(Short id) {
        return findById(id).orElseThrow(
                () -> new EntityNotFoundException("해당하는 카테고리가 없습니다."));
    }
}
