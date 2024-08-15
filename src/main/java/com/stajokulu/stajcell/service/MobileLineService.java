package com.stajokulu.stajcell.service;

import com.stajokulu.stajcell.model.entity.Customer;
import com.stajokulu.stajcell.model.entity.MobileLine;
import com.stajokulu.stajcell.repository.MobileLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MobileLineService {

    private final CustomerService customerService;

    private final MobileLineRepository mobileLineRepository;

    public MobileLine find(String number) {
        return mobileLineRepository.findById(number).orElse(null);
    }

    public List<MobileLine> findByCustomer(String customerIdentityNo) {

        return mobileLineRepository.findMobileLinesByCustomerIs(customerIdentityNo);
    }

    public MobileLine create(String number, String customerNo) {

        Customer customer = customerService.find(customerNo);

        if (Objects.isNull(customer)) {
            throw new RuntimeException("Customer not found by id: " + customerNo);
        }

        MobileLine mobileLine = new MobileLine();

        mobileLine.setNumber(number);
        mobileLine.setOpenDate(String.valueOf(LocalDateTime.now().getYear()));
        mobileLine.setActive(true);
        mobileLine.setCustomer(customer);

        return mobileLineRepository.save(mobileLine);
    }
}
