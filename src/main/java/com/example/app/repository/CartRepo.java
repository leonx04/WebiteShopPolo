package com.example.app.repository;

import com.example.app.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dungn
 */
@Repository
public interface CartRepo extends JpaRepository<CartEntity, Integer> {
}
