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
@Table(name = "account", schema = "dbo", catalog = "ShopPoloWeb")
public class AccountEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "username", nullable = true, length = 255)
    private String username;

    @Basic
    @Column(name = "password", nullable = true, length = 255)
    private String password;

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    private String email;

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    private String address;

    @Basic
    @Column(name = "phone_number", nullable = true, length = 255)
    private String phoneNumber;

    @Basic
    @Column(name = "salary", nullable = true, precision = 0)
    private Integer salary;

    @Basic
    @Column(name = "date_of_birth", nullable = true)
    private Date dateOfBirth;

    @Basic
    @Column(name = "status", nullable = true)
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private RoleEntity roleByRoleId;

    @OneToMany(mappedBy = "accountByAccountId")
    private Collection<CustomerEntity> customersById;

    @OneToMany(mappedBy = "accountByAccountId")
    private Collection<StaffEntity> staffById;

}
