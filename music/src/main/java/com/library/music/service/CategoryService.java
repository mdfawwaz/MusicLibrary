package com.library.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.music.entity.Category;
import com.library.music.repository.CategoryRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Method to create a new category
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Method to retrieve all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Method to retrieve a category by ID
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with ID: " + categoryId));
    }

    // You can add more methods for additional category-related operations as needed
}
