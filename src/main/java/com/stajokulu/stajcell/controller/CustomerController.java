package com.stajokulu.stajcell.controller;

import com.stajokulu.stajcell.model.CustomerDto;
import com.stajokulu.stajcell.model.entity.Customer;
import com.stajokulu.stajcell.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/all")
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{identityNumber}")
    public Customer findCustomer(@PathVariable String identityNumber) {
        return customerService.find(identityNumber);
    }

    @PostMapping("/create")
    public Customer create(@RequestParam String identityNumber,
                           @RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String gender,
                           @RequestParam String birthYear,
                           @RequestParam String address) {

        return customerService.create(identityNumber, name, surname, gender, birthYear, address);
    }
}
