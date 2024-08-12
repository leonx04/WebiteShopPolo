package com.example.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

/**
 * @author dungn
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "ProductDetail_image", schema = "dbo", catalog = "ShopPoloWeb")
public class ProductDetailImageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "image_url", nullable = true, length = 255)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "product_detail_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ProductDetailEntity productDetailByProductDetailId;

}
