package com.stajokulu.stajcell.repository;

import com.stajokulu.stajcell.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
