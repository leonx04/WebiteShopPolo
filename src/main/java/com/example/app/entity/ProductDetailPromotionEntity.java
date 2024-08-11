package com.example.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author dungn
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_detail_promotion", schema = "dbo", catalog = "ShopPoloWeb")
public class ProductDetailPromotionEntity {
    @EmbeddedId
    private ProductDetailPromotionEntityPK id;

    @ManyToOne
    @JoinColumn(name = "promotion_id", referencedColumnName = "id", insertable = false, updatable = false)
    private PromotionEntity promotionByPromotionId;

    @ManyToOne
    @JoinColumn(name = "product_detail_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ProductDetailEntity productDetailByProductDetailId;
}