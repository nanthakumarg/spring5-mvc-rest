package com.thebytecloud.services;

import com.thebytecloud.api.v1.model.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerByName(String name);

    CustomerDTO createNewCustomer(CustomerDTO customerDTO);

}
