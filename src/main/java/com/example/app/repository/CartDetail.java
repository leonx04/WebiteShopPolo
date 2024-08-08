package com.example.app.repository;

import com.example.app.entity.CartDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dungn
 */
@Repository
public interface CartDetail extends JpaRepository<CartDetailEntity, Integer> {
}
