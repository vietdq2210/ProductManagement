
import javax.persistence.*;

@Entity
@Table(name = "warehouse_product")
public class WarehouseProduct {
    @Id
    @Column(name = "id")
    private Integer id;

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
    private java.sql.Timestamp startDate;

    @Column(name = "expired_date")
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
