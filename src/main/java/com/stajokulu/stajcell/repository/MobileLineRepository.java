package com.stajokulu.stajcell.repository;

import com.stajokulu.stajcell.model.entity.MobileLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MobileLineRepository extends JpaRepository<MobileLine, String> {

    @Query("SELECT m FROM MobileLine as m WHERE m.customer.identityNumber = ?1")
    List<MobileLine> findMobileLinesByCustomerIs(String customerIdentityNo);
}
