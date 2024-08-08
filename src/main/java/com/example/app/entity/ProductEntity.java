package com.example.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
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
@Table(name = "product", schema = "dbo", catalog = "ShopPoloWeb")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "code", nullable = true, length = 255)
    private String code;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;

    @Basic
    @Column(name = "image_url", nullable = true, length = 255)
    private String imageUrl;

    @Transient
    private MultipartFile imageFile;
    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    private BigDecimal price;
    @Basic
    @Column(name = "description", nullable = true, length = 255)
    private String description;

    @Basic
    @Column(name = "create_at", nullable = true)
    private Date createAt;
    @Basic
    @Column(name = "update_at", nullable = true)
    private Date updateAt;
    @OneToMany(mappedBy = "productByProductId")
    private Collection<ProductDetailEntity> productDetailsById;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoryEntity categoryByCategoryId;
    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private BrandEntity brandByBrandId;

}
