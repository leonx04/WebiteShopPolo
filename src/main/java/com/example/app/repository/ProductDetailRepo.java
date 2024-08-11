package com.example.app.repository;

import com.example.app.entity.ProductDetailEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author dungn
 */
public interface ProductDetailRepo extends JpaRepository<ProductDetailEntity, Integer> {

    @Query("SELECT pd FROM ProductDetailEntity pd " +
            "LEFT JOIN pd.productByProductId p " +
            "LEFT JOIN pd.colorByColorId c " +
            "LEFT JOIN pd.sizeBySizeId s " +
            "LEFT JOIN pd.materialByMaterialId m " +
            "WHERE (:productName IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :productName, '%'))) " +
            "AND (:color IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :color, '%'))) " +
            "AND (:size IS NULL OR LOWER(s.name) LIKE LOWER(CONCAT('%', :size, '%'))) " +
            "AND (:material IS NULL OR LOWER(m.name) LIKE LOWER(CONCAT('%', :material, '%'))) " +
            "AND (:code IS NULL OR LOWER(pd.code) LIKE LOWER(CONCAT('%', :code, '%')))")
    Page<ProductDetailEntity> findByFilters(
            @Param("productName") String productName,
            @Param("color") String color,
            @Param("size") String size,
            @Param("material") String material,
            @Param("code") String code,
            Pageable pageable);
}