package com.ghtk.productmanagement.repository;

import com.ghtk.productmanagement.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    @Query("SELECT p FROM ProductEntity p WHERE " +
            "p.name LIKE '%áo%' AND " +
            "p.price > 50000")
    List<ProductEntity> searchProduct();


}
