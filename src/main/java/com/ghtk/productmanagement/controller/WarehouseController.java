package com.ghtk.productmanagement.controller;

import com.ghtk.productmanagement.model.dto.WarehouseDTO;
import com.ghtk.productmanagement.model.response.CommonResponse;
import com.ghtk.productmanagement.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/warehouse")
public class WarehouseController {
    @Autowired
    WareHouseService wareHouseService;

    @PostMapping("/create")
    public ResponseEntity<CommonResponse> createWareHouse(@RequestBody WarehouseDTO warehouseDTO
            ,@RequestParam Long provinceId ,@RequestParam Long districtId){
        return wareHouseService.insertWarehouse(warehouseDTO,provinceId,districtId);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<CommonResponse> delete(@PathVariable Long id){
        return wareHouseService.deleteWarehouse(id);
    }
}
