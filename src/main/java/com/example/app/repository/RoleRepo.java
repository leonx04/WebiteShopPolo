package com.example.app.repository;

import com.example.app.entity.RoleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntity, Integer> {
    @Query("SELECT r FROM RoleEntity r WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    Page<RoleEntity> findByNameContaining(String name, Pageable pageable);

    @Query("SELECT COUNT(a) FROM AccountEntity a WHERE a.roleByRoleId.id = :roleId")
    Long countAccountsByRoleId(Integer roleId);
}