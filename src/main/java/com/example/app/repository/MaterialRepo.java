package com.example.app.repository;

import com.example.app.entity.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dungn
 */
@Repository
public interface MaterialRepo extends JpaRepository<MaterialEntity, Integer> {
}
