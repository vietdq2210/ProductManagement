package com.ghtk.productmanagement.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "warehouse_product")
public class WarehouseProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "warehouse_id")
    private Integer warehouseId;

    @Column(name = "inventory")
    private Integer inventory;

    @Column(name = "total_import")
    private Integer totalImport;

    @Column(name = "total_export")
    private Integer totalExport;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "expired_date")
    private Date expiredDate;

}
