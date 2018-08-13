package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.entity.Customer;

public interface CustomerRespository extends JpaRepository<Customer, Long> {

}
