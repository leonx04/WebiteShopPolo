package com.example.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

/**
 * @author dungn
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CartDetail", schema = "dbo", catalog = "ShopPoloWeb")
public class CartDetailEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "quantity", nullable = true)
    private Integer quantity;

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    private BigDecimal price;

    @Basic
    @Column(name = "create_at", nullable = true)
    private Date createAt;

    @Basic
    @Column(name = "update_at", nullable = true)
    private Date updateAt;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id", insertable = false, updatable = false)
    private CartEntity cartByCartId;

    @ManyToOne
    @JoinColumn(name = "product_detail_id", referencedColumnName = "id")
    private ProductDetailEntity productDetailByProductDetailId;

}
