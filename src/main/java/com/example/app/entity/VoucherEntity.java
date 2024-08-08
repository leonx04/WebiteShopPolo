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
@Table(name = "voucher", schema = "dbo", catalog = "ShopPoloWeb")
public class VoucherEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "code", nullable = true, length = 255)
    private String code;
    @Basic
    @Column(name = "discount_amount", nullable = true, precision = 0)
    private Integer discountAmount;
    @Basic
    @Column(name = "discount_percentage", nullable = true, precision = 0)
    private Integer discountPercentage;
    @Basic
    @Column(name = "start_date", nullable = true)
    private Date startDate;
    @Basic
    @Column(name = "end_date", nullable = true)
    private Date endDate;
    @Basic
    @Column(name = "minimum_order_amount", nullable = true, precision = 0)
    private Integer minimumOrderAmount;
    @Basic
    @Column(name = "voucher_type", nullable = true, length = 255)
    private String voucherType;
    @Basic
    @Column(name = "max_discount_amount", nullable = true, precision = 0)
    private Integer maxDiscountAmount;
    @Basic
    @Column(name = "usage_limit", nullable = true)
    private Integer usageLimit;
    @Basic
    @Column(name = "status", nullable = true)
    private Integer status;
    @Basic
    @Column(name = "create_at", nullable = true)
    private Date createAt;
    @Basic
    @Column(name = "update_at", nullable = true)
    private Date updateAt;
    @OneToMany(mappedBy = "voucherByVoucherId")
    private Collection<VoucherUsageEntity> voucherUsagesById;

}
