package com.ghtk.productmanagement.service;

import com.ghtk.productmanagement.model.dto.CategoryDTO;
import com.ghtk.productmanagement.model.entity.Category;
import com.ghtk.productmanagement.model.response.CommonResponse;
import org.springframework.http.ResponseEntity;

public interface CategoryService {
    Category getById(Long id);
    ResponseEntity<CommonResponse> getAllCategory(int page, int pageSize);

    ResponseEntity<CommonResponse> insertCategory(CategoryDTO categoryDTO);

}
