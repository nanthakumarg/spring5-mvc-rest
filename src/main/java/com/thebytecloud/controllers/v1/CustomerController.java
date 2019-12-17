package com.thebytecloud.controllers.v1;

import com.thebytecloud.api.v1.model.CustomerDTO;
import com.thebytecloud.api.v1.model.CustomerListDTO;
import com.thebytecloud.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("{name}")
//    public ResponseEntity<CustomerDTO> getCustomerByName(@PathVariable String name) {
//        return new ResponseEntity<CustomerDTO>(
//                customerService.getCustomerByName(name),
//                HttpStatus.OK
//        );
//    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        return new ResponseEntity<CustomerDTO>(
                customerService.getCustomerById(id),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createNewCustomer(@RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<CustomerDTO>(customerService.createNewCustomer(customerDTO),
                HttpStatus.CREATED);
    }

}
