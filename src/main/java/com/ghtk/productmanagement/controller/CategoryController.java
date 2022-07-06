//package com.ghtk.productmanagement.controller;
//
//import com.ghtk.productmanagement.repository.CategoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/v1.0/category")
//public class CategoryController {
//
//    @Autowired
//    CategoryRepository categoryRepository;
//
//    @GetMapping("/get")
//    public ResponseEntity get(
//            @RequestParam(value = "page") int page,
//            @RequestParam(value = "page_size") int pageSize
//    ){
//        Page<CategoryEntity> categoryEntities = categoryRepository.findAll(PageRequest.of(page,pageSize));
//        return ResponseEntity.ok(categoryEntities);
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity create(
//            @RequestBody CategoryEntity categoryEntity
//            ){
//        return ResponseEntity.ok(categoryRepository.save(categoryEntity));
//
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity update(
//            @RequestBody CategoryEntity categoryEntity
//    ) {
//        return ResponseEntity.ok(categoryRepository.save(categoryEntity));
//    }
//    @DeleteMapping("delete/{id}")
//    public ResponseEntity delete(
//            @PathVariable Long id
//    ) {
//        Optional<CategoryEntity> categoryEntity = categoryRepository.findById(id);
//        return ResponseEntity.ok("Thanh cong");
//    }
//}
