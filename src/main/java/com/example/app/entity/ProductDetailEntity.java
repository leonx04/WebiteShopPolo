package com.example.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

/**
 * @author dungn
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "ProductDetail", schema = "dbo", catalog = "ShopPoloWeb")
public class ProductDetailEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;


    @Basic
    @Column(name = "quantity", nullable = true)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ProductEntity productByProductId;

    @ManyToOne
    @JoinColumn(name = "color_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ColorEntity colorByColorId;

    @ManyToOne
    @JoinColumn(name = "size_id", referencedColumnName = "id")
    private SizeEntity sizeBySizeId;

    @ManyToOne
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    private MaterialEntity materialByMaterialId;

    @OneToMany(mappedBy = "productDetailByProductDetailId")
    private Collection<ProductDetailImageEntity> productDetailImagesById;

    @OneToMany(mappedBy = "productDetailByProductDetailId")
    private Collection<ProductDetailPromotionEntity> productDetailPromotionsById;
}
