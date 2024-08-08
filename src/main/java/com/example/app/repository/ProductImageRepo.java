package com.example.app.repository;

import com.example.app.entity.ProductDetailImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dungn
 */
@Repository
public interface ProductImageRepo extends JpaRepository<ProductDetailImageEntity, Integer> {
}
