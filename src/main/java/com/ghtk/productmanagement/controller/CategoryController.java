package com.ghtk.productmanagement.controller;

import com.ghtk.productmanagement.model.dto.CategoryDTO;
import com.ghtk.productmanagement.model.response.CommonResponse;
import com.ghtk.productmanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity get(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "page_size") int pageSize
    ) {
        return categoryService.getAllCategory(page, pageSize);
    }
    @PostMapping("")
    public ResponseEntity<CommonResponse> insertCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.insertCategory(categoryDTO);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody CategoryDTO categoryDTO) {
        return null;
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok("Thanh cong");
    }
}
