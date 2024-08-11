package com.example.app.service;

import com.example.app.entity.AccountEntity;
import com.example.app.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountEntity account = accountRepo.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("User not found");
        }

        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + account.getRoleByRoleId().getName().toUpperCase()));

        return new org.springframework.security.core.userdetails.User(account.getUsername(), account.getPassword(), authorities);
    }
}