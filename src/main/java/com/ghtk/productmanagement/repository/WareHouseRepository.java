package com.ghtk.productmanagement.repository;

import com.ghtk.productmanagement.model.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WareHouseRepository extends JpaRepository<Warehouse,Long> {
}
