package com.ghtk.productmanagement.service.impl;

import com.ghtk.productmanagement.model.dto.CategoryDTO;
import com.ghtk.productmanagement.model.entity.Category;
import com.ghtk.productmanagement.model.response.CommonResponse;
import com.ghtk.productmanagement.repository.CategoryRepository;
import com.ghtk.productmanagement.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public ResponseEntity<CommonResponse> getAllCategory(int page, int pageSize) {
        Page<Category> categoryPage = categoryRepository.findByStatus(1, PageRequest.of(page, pageSize));
        return ResponseEntity.status(HttpStatus.OK).body(
                new CommonResponse("OK", "Get all category successfully",
                        categoryPage.stream().map(category -> modelMapper.map(category, CategoryDTO.class))));
    }
    @Override
    public ResponseEntity<CommonResponse> insertCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        category.setStatus(1);
        return ResponseEntity.status(HttpStatus.OK).body(
                new CommonResponse("OK","Insert category successfully", categoryRepository.save(category))
        );
    }
}
