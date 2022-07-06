package com.ghtk.productmanagement.service;

import com.ghtk.productmanagement.model.dto.ProductDTO;
import com.ghtk.productmanagement.model.entity.Product;
import com.ghtk.productmanagement.model.response.CommonResponse;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ProductService {
    ResponseEntity<CommonResponse> getAllProduct(int page, int pageSize);
    ResponseEntity<CommonResponse> insertProduct(ProductDTO productDTO);
    ResponseEntity<CommonResponse> updateProduct(Product product,Long id);
    ResponseEntity<CommonResponse> deleteProduct(Long id);
}
