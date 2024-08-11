package com.example.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;

/**
 * @author dungn
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "product_detail", schema = "dbo", catalog = "ShopPoloWeb")
public class ProductDetailEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "code", nullable = true, length = 50)
    private String code;

    @Basic
    @Column(name = "price", nullable = true)
    private Integer price;


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
    @Column(name = "create_at", nullable = true)
    private Date createAt;
    @Column(name = "update_at", nullable = true)
    private Date updateAt;
}
