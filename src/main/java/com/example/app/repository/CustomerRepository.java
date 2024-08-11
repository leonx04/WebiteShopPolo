package com.example.app.repository;

import com.example.app.entity.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    @Query("SELECT c FROM CustomerEntity c WHERE " +
            "(:name IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
            "(:email IS NULL OR LOWER(c.email) LIKE LOWER(CONCAT('%', :email, '%'))) AND " +
            "(:phone IS NULL OR c.phoneNumber LIKE CONCAT('%', :phone, '%'))")
    Page<CustomerEntity> search(
            @Param("name") String name,
            @Param("email") String email,
            @Param("phone") String phone,
            Pageable pageable);
}