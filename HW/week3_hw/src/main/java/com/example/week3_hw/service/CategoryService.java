package com.example.week3_hw.service;

import com.example.week3_hw.domain.Category;
import com.example.week3_hw.domain.CategoryId;
import com.example.week3_hw.dto.request.category.CategoryResponse;
import com.example.week3_hw.repository.CategoryJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryJpaRepository categoryJpaRepository;

    public Category getByCategoryId(CategoryId categoryId) {
        return categoryJpaRepository.findByIdOrThrow(Short.valueOf(String.valueOf(categoryId)));
    }

    public CategoryResponse getById(Short id) {
        return CategoryResponse.of(categoryJpaRepository.findByIdOrThrow(id));
    }
}
