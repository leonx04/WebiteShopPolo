package com.example.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Table(name = "promotion", schema = "dbo", catalog = "ShopPoloWeb")
public class PromotionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "start_date", nullable = true)
    private Date startDate;
    @Basic
    @Column(name = "end_date", nullable = true)
    private Date endDate;
    @Basic
    @Column(name = "discount_percentage", nullable = true, precision = 0)
    private BigDecimal discountPercentage;
    @Basic
    @Column(name = "discount_amount", nullable = true, precision = 0)
    private BigDecimal discountAmount;
    @Basic
    @Column(name = "promotion_type", nullable = true, length = 255)
    private String promotionType;
    @Basic
    @Column(name = "status", nullable = true)
    private Integer status;
    @Basic
    @Column(name = "create_at", nullable = true)
    private Date createAt;
    @Basic
    @Column(name = "update_at", nullable = true)
    private Date updateAt;
    @OneToMany(mappedBy = "promotionByPromotionId")
    private Collection<ProductDetailPromotionEntity> productDetailPromotionsById;

}
