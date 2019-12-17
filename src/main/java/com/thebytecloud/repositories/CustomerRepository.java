package com.thebytecloud.repositories;

import com.thebytecloud.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByFirstname(String name);

}
