package com.example.app.repository;

import com.example.app.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dungn
 */
@Repository
public interface PromotionRepo extends JpaRepository<PromotionEntity, Integer> {
}
