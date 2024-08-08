package com.example.app.repository;

import com.example.app.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dungn
 */
@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetailEntity, Integer> {
}
