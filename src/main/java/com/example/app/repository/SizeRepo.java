package com.example.app.repository;

import com.example.app.entity.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dungn
 */
@Repository
public interface SizeRepo extends JpaRepository<SizeEntity, Integer> {
}
