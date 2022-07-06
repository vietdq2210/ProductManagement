package com.ghtk.productmanagement.service.impl;

import com.ghtk.productmanagement.model.entity.Province;
import com.ghtk.productmanagement.repository.ProvinceRepository;
import com.ghtk.productmanagement.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;
    @Override
    public Province getById(Long id) {
        return provinceRepository.findById(id).get();
    }
}
