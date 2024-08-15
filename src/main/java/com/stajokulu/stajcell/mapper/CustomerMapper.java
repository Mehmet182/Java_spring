package com.stajokulu.stajcell.mapper;

import com.stajokulu.stajcell.model.CustomerDto;
import com.stajokulu.stajcell.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDto mapToCustomerDto(Customer customer);

    List<CustomerDto> mapToCustomerDtoList(List<Customer> customerList);
}
