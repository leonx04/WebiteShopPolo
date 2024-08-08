package com.example.app.repository;

import com.example.app.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dungn
 */
@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, Integer> {
}
