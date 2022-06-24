package com.ghtk.productmanagement.controller;

import com.ghtk.productmanagement.entity.ProductEntity;
import com.ghtk.productmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1.0/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("")
    public ResponseEntity get(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "page_size") int pageSize
    ){
        Page<ProductEntity> productEntities = productRepository.findAll(PageRequest.of(page,pageSize));
        return ResponseEntity.ok(productEntities);
    }

    @PostMapping("")
    public ResponseEntity create(
            @RequestBody ProductEntity productEntity
    ){
        return ResponseEntity.ok(productRepository.save(productEntity));
    }

    @PutMapping("")
    public ResponseEntity update(
            @RequestBody ProductEntity productEntity
    ){
        return ResponseEntity.ok(productRepository.save(productEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(
            @PathVariable Long id
    ){
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        return ResponseEntity.ok("Thanh cong");
    }


    @GetMapping("/search")
    public ResponseEntity<List<ProductEntity>> searchProduct(){
        return ResponseEntity.ok(productRepository.searchProduct());
    }


}
