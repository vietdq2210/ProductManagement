package com.ghtk.productmanagement.repository;

import com.ghtk.productmanagement.model.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DistrictRepository extends JpaRepository<District,Long> {
}
