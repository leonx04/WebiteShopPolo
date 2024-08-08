package com.example.app.repository;

import com.example.app.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dungn
 */
@Repository
public interface AccountRepo extends JpaRepository<AccountEntity, Integer> {
    AccountEntity findByUsername(String username);
}
