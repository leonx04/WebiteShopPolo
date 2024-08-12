package com.example.app.repository;

import com.example.app.entity.ProductDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dungn
 */
@Repository
public interface ProductDetailRepo extends JpaRepository<ProductDetailEntity, Integer> {
}
