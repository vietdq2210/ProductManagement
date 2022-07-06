package com.ghtk.productmanagement.service.impl;

import com.ghtk.productmanagement.model.entity.Category;
import com.ghtk.productmanagement.repository.CategoryRepository;
import com.ghtk.productmanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id).get();
    }
}
