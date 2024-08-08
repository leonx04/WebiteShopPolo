package com.example.app.repository;

import com.example.app.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author dungn
 */
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {

    @Query("SELECT p FROM ProductEntity p WHERE " +
            "(:code = '' OR p.code LIKE %:code%) AND " +
            "(:name = '' OR p.name LIKE %:name%) AND " +
            "(:brandId IS NULL OR p.brandByBrandId.id = :brandId) AND " +
            "(:categoryId IS NULL OR p.categoryByCategoryId.id = :categoryId)")
    Page<ProductEntity> search(@Param("code") String code,
                               @Param("name") String name,
                               @Param("brandId") Integer brandId,
                               @Param("categoryId") Integer categoryId,
                               Pageable pageable);

}