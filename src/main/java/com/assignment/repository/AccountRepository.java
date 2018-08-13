package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findBycustomerId(Long custId);
}
