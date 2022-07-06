package com.ghtk.productmanagement.service.impl;

import com.ghtk.productmanagement.model.dto.ProductDTO;
import com.ghtk.productmanagement.model.entity.Product;
import com.ghtk.productmanagement.model.response.CommonResponse;
import com.ghtk.productmanagement.repository.ProductRepository;
import com.ghtk.productmanagement.service.CategoryService;
import com.ghtk.productmanagement.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    CategoryService categoryService;
    @Override
    public ResponseEntity<CommonResponse> getAllProduct(int page, int pageSize) {
        Page<Product> productPage = productRepository.findByStatus(1, PageRequest.of(page, pageSize));
        return ResponseEntity.status(HttpStatus.OK).body(
                new CommonResponse("OK", "Get all product successfully",
                        productPage.stream().map(product -> modelMapper.map(product, ProductDTO.class))));
    }
    @Override
    public ResponseEntity<CommonResponse> insertProduct(ProductDTO productDTO) {
        if(productDTO.getPrice() <= 0  || productDTO.getName() == null || productDTO.getName().length() > 100){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new CommonResponse("Failed","Insert product failed","")
            );
        }
        Product product = modelMapper.map(productDTO,Product.class);
        product.setStatus(1);
        product.setCreatedAt(LocalDateTime.now());
        product.setModifiedAt(LocalDateTime.now());
        product.setCategoryId(productDTO.getCategoryId());
        product.setCode(categoryService.getById(productDTO.getCategoryId()).getCode()+ "." +
                product.getSku()+  "." + product.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        return ResponseEntity.status(HttpStatus.OK).body(
                new CommonResponse("OK","Insert product successfully",productRepository.save(product))
        );
    }
    @Override
    public ResponseEntity<CommonResponse> updateProduct(Product productEntity ,Long id) {
        Product updateProduct = productRepository.findById(id)
                .map(product -> {
                    product.setName(productEntity.getName());
                    product.setPrice(productEntity.getPrice());
                    product.setDescription(product.getDescription());
                    product.setStatus(1);
                    product.setCode(categoryService.getById(productEntity.getCategoryId()).getCode()+ "." +
                            product.getSku()+  "." + product.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
                    product.setSku(productEntity.getSku());
                    return productRepository.save(product);
                }).orElseGet(() ->{
                    productEntity.setId(id);
                    return productRepository.save(productEntity);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new CommonResponse("ok","Update product success",updateProduct)
        );
    }
    @Override
    public ResponseEntity<CommonResponse> deleteProduct(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        Product products = productRepository.findById(id).get();
        if(productOptional.isEmpty() || products.getStatus() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new CommonResponse("fail","Id not found" + " " + id,"")
            );
        }else if(products.getStatus() == 1){
            productOptional.map(product -> {
                product.setStatus(0);
                return productRepository.save(product);
            });
            return ResponseEntity.status(HttpStatus.OK).body(
                    new CommonResponse("ok","Delete successfully",productOptional)
            );
        }
        return null;
    }


}

