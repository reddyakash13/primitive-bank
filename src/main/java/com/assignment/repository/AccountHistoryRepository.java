package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.entity.AccountHistory;

public interface AccountHistoryRepository extends JpaRepository<AccountHistory, Long> {

}
