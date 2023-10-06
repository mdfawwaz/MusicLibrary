package com.library.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.music.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Custom queries if needed
}
