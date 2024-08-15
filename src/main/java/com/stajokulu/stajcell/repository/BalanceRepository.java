package com.stajokulu.stajcell.repository;

import com.stajokulu.stajcell.model.entity.BalanceUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BalanceRepository extends JpaRepository<BalanceUnit, Long> {

    @Query("SELECT b FROM BalanceUnit as b WHERE b.mobileLine.number = ?1")
    List<BalanceUnit> findBalanceUnitsByMobileLineIs(String number);
}
