package com.ghtk.productmanagement.service;

import com.ghtk.productmanagement.model.dto.ProductDTO;
import com.ghtk.productmanagement.model.dto.WarehouseDTO;
import com.ghtk.productmanagement.model.entity.Product;
import com.ghtk.productmanagement.model.entity.Warehouse;
import com.ghtk.productmanagement.model.response.CommonResponse;
import org.springframework.http.ResponseEntity;

public interface WareHouseService {
    ResponseEntity<CommonResponse> insertWarehouse(WarehouseDTO warehouseDTO, Long provinceId, Long districtId);

    ResponseEntity<CommonResponse> updateWarehouse(Warehouse warehouse, Long id);

    ResponseEntity<CommonResponse> deleteWarehouse(Long id);

}
