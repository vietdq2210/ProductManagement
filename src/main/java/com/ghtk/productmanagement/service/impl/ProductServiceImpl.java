package com.ghtk.productmanagement.service.impl;

import com.ghtk.productmanagement.repository.ProductRepository;
import com.ghtk.productmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;




}
