package com.stajokulu.stajcell.controller;

import com.stajokulu.stajcell.model.entity.MobileLine;
import com.stajokulu.stajcell.service.MobileLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mobile-line")
@RequiredArgsConstructor
public class MobileLineController {

    private final MobileLineService mobileLineService;

    @GetMapping("/find-by-customer")
    public List<MobileLine> findByCustomer(@RequestParam String customerNo) {
        return mobileLineService.findByCustomer(customerNo);
    }

    @PostMapping("/create")
    public MobileLine create(@RequestParam String number,
                           @RequestParam String customerNo) {

        return mobileLineService.create(number, customerNo);
    }
}
