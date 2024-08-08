package com.example.app.repository;

import com.example.app.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dungn
 */
@Repository
public interface OrderRepo extends JpaRepository<OrderEntity, Integer> {
}
