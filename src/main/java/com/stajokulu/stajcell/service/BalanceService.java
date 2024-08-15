package com.stajokulu.stajcell.service;

import com.stajokulu.stajcell.model.BalanceType;
import com.stajokulu.stajcell.model.entity.BalanceUnit;
import com.stajokulu.stajcell.model.entity.MobileLine;
import com.stajokulu.stajcell.repository.BalanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BalanceService {

    private final BalanceRepository balanceRepository;

    private final MobileLineService mobileLineService;

    public List<BalanceUnit> getBalances(String number) {

        MobileLine mobileLine = mobileLineService.find(number);
        if (Objects.isNull(mobileLine)) {
            throw new RuntimeException("Mobile line is not found by number: " + number);
        }

        List<BalanceUnit> balanceUnitList = balanceRepository.findBalanceUnitsByMobileLineIs(number);
        if (CollectionUtils.isEmpty(balanceUnitList)) {
            throw new RuntimeException("There is no balance by number: " + number);
        }

        return balanceUnitList;
    }

    public String addBalance(String number, BalanceType kind, Double amount) {

        MobileLine mobileLine = mobileLineService.find(number);
        if (Objects.isNull(mobileLine)) {
            throw new RuntimeException("Mobile line is not found by number: " + number);
        }

        BalanceUnit balanceUnit = new BalanceUnit();

        balanceUnit.setAmount(amount);
        balanceUnit.setKind(kind);
        balanceUnit.setMobileLine(mobileLine);

        balanceRepository.save(balanceUnit);

        return "Balance is recorded successfully!";
    }

}
