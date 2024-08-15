package com.stajokulu.stajcell.service;

import com.stajokulu.stajcell.mapper.CustomerMapper;
import com.stajokulu.stajcell.model.CustomerDto;
import com.stajokulu.stajcell.model.entity.Customer;
import com.stajokulu.stajcell.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<CustomerDto> getAllCustomers() {

        List<Customer> customerList = customerRepository.findAll();

        /*
        MANUEL MAPPING

        List<CustomerDto> customerDtoList = customerList.stream().map(customer -> {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setIdentityNumber(customer.getIdentityNumber());
            customerDto.setName(customer.getName());
            customerDto.setSurname(customer.getSurname());

            return customerDto;
        }).toList();

         */

        List<CustomerDto> customerDtoList = CustomerMapper.INSTANCE.mapToCustomerDtoList(customerList);

        return customerDtoList;
    }

    public Customer create(String identityNumber, String name, String surname, String gender, String birthYear, String address) {

        Customer customer = new Customer();

        customer.setIdentityNumber(identityNumber);
        customer.setName(name);
        customer.setSurname(surname);
        customer.setGender(gender);
        customer.setBirthYear(birthYear);
        customer.setAddress(address);

        return customerRepository.save(customer);
    }

    public Customer find(String identityNumber) {

        return customerRepository.findById(identityNumber).orElse(null);
    }
}
