package com.ghtk.productmanagement.controller;

import com.ghtk.productmanagement.model.dto.ProductDTO;
import com.ghtk.productmanagement.model.entity.Product;
import com.ghtk.productmanagement.model.response.CommonResponse;
import com.ghtk.productmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1.0/product")
public class ProductController {

    @Autowired
    private ProductService productService;

//    @GetMapping("/get")
//    public ResponseEntity<ProductDTO> get(
//            @RequestParam(value = "page") int page,
//            @RequestParam(value = "page_size") int pageSize
//    ){
//        Page<Product> productPage = productService.findAll(PageRequest.of(page,pageSize));
//        ProductDTO productDTO = new ProductDTO();
//        BeanUtils.copyProperties(productPage,productDTO);
//        return ResponseEntity.ok(productDTO);
//    }

    @PostMapping("/create")
    public ResponseEntity<CommonResponse> insertProduct(@RequestBody ProductDTO productDTO){
        return productService.insertProduct(productDTO);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<CommonResponse> update(
            @RequestBody Product productEntity,@PathVariable Long id){
        return productService.updateProduct(productEntity,id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<CommonResponse> delete(@PathVariable Long id){
        return productService.deleteProduct(id);
    }


//    @GetMapping("/search")
//    public ResponseEntity<List<Product>> searchProduct(){
//
//        return ResponseEntity.ok(productService.searchProduct());
//    }


}
