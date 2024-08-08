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
@Table(name = "staff", schema = "dbo", catalog = "ShopPoloWeb")
public class StaffEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "gender", nullable = true, length = 255)
    private String gender;
    @Basic
    @Column(name = "date_of_birth", nullable = true)
    private Date dateOfBirth;
    @Basic
    @Column(name = "phone_number", nullable = true, length = 255)
    private String phoneNumber;
    @Basic
    @Column(name = "email", nullable = true, length = 255)
    private String email;
    @Basic
    @Column(name = "address", nullable = true, length = 255)
    private String address;
    @Basic
    @Column(name = "salary", nullable = true, precision = 0)
    private Integer salary;

    @Basic
    @Column(name = "hire_date", nullable = true)
    private Date hireDate;
    @Basic
    @Column(name = "status", nullable = true)
    private Integer status;
    @Basic
    @Column(name = "notes", nullable = true, length = 255)
    private String notes;
    @Basic
    @Column(name = "create_at", nullable = true)
    private Date createAt;
    @Basic
    @Column(name = "update_at", nullable = true)
    private Date updateAt;
    @OneToMany(mappedBy = "staffByStaffId")
    private Collection<OrderEntity> ordersById;
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private AccountEntity accountByAccountId;

}
