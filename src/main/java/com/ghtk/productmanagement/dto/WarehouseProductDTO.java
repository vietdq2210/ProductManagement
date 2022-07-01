package com.ghtk.productmanagement.dto;

public class WarehouseProductDTO {
    private Integer id;
    private Integer productId;
    private Integer warehouseId;
    private Integer inventory;
    private Integer totalImport;
    private Integer totalExport;
    private java.sql.Timestamp startDate;
    private java.sql.Timestamp expiredDate;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getWarehouseId() {
        return this.warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getInventory() {
        return this.inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getTotalImport() {
        return this.totalImport;
    }

    public void setTotalImport(Integer totalImport) {
        this.totalImport = totalImport;
    }

    public Integer getTotalExport() {
        return this.totalExport;
    }

    public void setTotalExport(Integer totalExport) {
        this.totalExport = totalExport;
    }

    public java.sql.Timestamp getStartDate() {
        return this.startDate;
    }

    public void setStartDate(java.sql.Timestamp startDate) {
        this.startDate = startDate;
    }

    public java.sql.Timestamp getExpiredDate() {
        return this.expiredDate;
    }

    public void setExpiredDate(java.sql.Timestamp expiredDate) {
        this.expiredDate = expiredDate;
    }
}
