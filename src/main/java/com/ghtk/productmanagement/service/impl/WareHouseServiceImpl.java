package com.ghtk.productmanagement.service.impl;

import com.ghtk.productmanagement.model.dto.WarehouseDTO;
import com.ghtk.productmanagement.model.entity.Warehouse;
import com.ghtk.productmanagement.model.response.CommonResponse;
import com.ghtk.productmanagement.repository.WareHouseRepository;
import com.ghtk.productmanagement.service.DistrictService;
import com.ghtk.productmanagement.service.ProvinceService;
import com.ghtk.productmanagement.service.WareHouseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WareHouseServiceImpl implements WareHouseService {
    @Autowired
    private WareHouseRepository wareHouseRepository;
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ResponseEntity<CommonResponse> insertWarehouse(WarehouseDTO warehouseDTO,
     Long provinceId, Long districtId) {
        Warehouse warehouse = modelMapper.map(warehouseDTO,Warehouse.class);
        warehouse.setStatus(1);
        warehouse.setDistrictId(districtId);
        warehouse.setProvinceId(provinceId);
        warehouse.setAddress(warehouseDTO.getAddress() + " " + provinceService.getById(provinceId).getName() + " " +
                districtService.getById(districtId).getName());
        return ResponseEntity.status(HttpStatus.OK).body(
                new CommonResponse("ok","Insert warehouse successfully", wareHouseRepository.save(warehouse))
        );
    }
    @Override
    public ResponseEntity<CommonResponse> updateWarehouse(Warehouse warehouse, Long id) {
        return null;
    }
    @Override
    public ResponseEntity<CommonResponse> deleteWarehouse(Long id) {
        Optional<Warehouse> warehouseOptional = wareHouseRepository.findById(id);
        Warehouse warehouses = wareHouseRepository.findById(id).get();
        if(warehouseOptional.isEmpty() || warehouses.getStatus() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new CommonResponse("fail","Id not found" + " " + id,"")
            );
        }else if(warehouses.getStatus() == 1){
            warehouseOptional.map(product -> {
                product.setStatus(0);
                return wareHouseRepository.save(product);
            });
            return ResponseEntity.status(HttpStatus.OK).body(
                    new CommonResponse("ok","Delete successfully",warehouseOptional)
            );
        }
        return null;
    }
}
