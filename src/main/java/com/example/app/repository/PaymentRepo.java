package com.example.app.repository;

import com.example.app.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dungn
 */
@Repository
public interface PaymentRepo extends JpaRepository<PaymentEntity, Integer> {
}
