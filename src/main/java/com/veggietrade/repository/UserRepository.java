package com.veggietrade.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veggietrade.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByMobileNo(String mobileNo);
}