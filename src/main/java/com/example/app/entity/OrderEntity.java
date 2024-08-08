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
@Table(name = "order", schema = "dbo", catalog = "ShopPoloWeb")
public class OrderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "status", nullable = true)
    private Integer status;
    @Basic
    @Column(name = "order_date", nullable = true)
    private Date orderDate;
    @Basic
    @Column(name = "total_amount", nullable = true, precision = 0)
    private BigDecimal totalAmount;

    @Basic
    @Column(name = "voucher_id", nullable = true)
    private Integer voucherId;
    @Basic
    @Column(name = "create_at", nullable = true)
    private Date createAt;
    @Basic
    @Column(name = "update_at", nullable = true)
    private Date updateAt;
    @OneToMany(mappedBy = "orderByOrderId")
    private Collection<VoucherUsageEntity> voucherUsagesById;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private CustomerEntity customerByCustomerId;
    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    private StaffEntity staffByStaffId;
    @OneToMany(mappedBy = "orderByOrderId")
    private Collection<OrderDetailEntity> orderDetailsById;
    @OneToMany(mappedBy = "orderByOrderId")
    private Collection<PaymentEntity> paymentsById;

}
