package com.example.app.repository;

import com.example.app.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dungn
 */
@Repository
public interface BrandRepo  extends JpaRepository<BrandEntity, Integer> {
}
