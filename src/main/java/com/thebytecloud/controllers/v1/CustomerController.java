package com.thebytecloud.controllers.v1;

import com.thebytecloud.api.v1.model.CustomerDTO;
import com.thebytecloud.api.v1.model.CustomerListDTO;
import com.thebytecloud.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers/")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<CustomerListDTO> getAllCustomers() {
        return new ResponseEntity<CustomerListDTO>(
                new CustomerListDTO(customerService.getAllCustomers()), HttpStatus.OK
        );
    }

    @GetMapping("{name}")
    public ResponseEntity<CustomerDTO> getCustomerByName(@PathVariable String name) {
        return new ResponseEntity<CustomerDTO>(
                customerService.getCustomerByName(name),
                HttpStatus.OK
        );
    }

    //TODO: Implement create new customer

}
