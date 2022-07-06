package com.ghtk.productmanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WarehouseProductDTO {
    private Integer id;
    private Integer productId;
    private Integer warehouseId;
    private Integer inventory;
    private Integer totalImport;
    private Integer totalExport;
    private Date startDate;
    private Date expiredDate;
}
