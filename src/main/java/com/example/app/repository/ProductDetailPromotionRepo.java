package com.example.app.repository;

import com.example.app.entity.ProductDetailPromotionEntity;
import com.example.app.entity.ProductDetailPromotionEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dungn
 */
@Repository
public interface ProductDetailPromotionRepo extends JpaRepository<ProductDetailPromotionEntity, ProductDetailPromotionEntityPK> {
}