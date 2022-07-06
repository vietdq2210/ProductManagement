package com.ghtk.productmanagement.service.impl;

import com.ghtk.productmanagement.model.entity.District;
import com.ghtk.productmanagement.repository.DistrictRepository;
import com.ghtk.productmanagement.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;
    @Override
    public District getById(Long id) {
        return districtRepository.findById(id).get();
    }
}
