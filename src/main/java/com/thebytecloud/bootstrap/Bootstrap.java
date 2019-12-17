package com.thebytecloud.bootstrap;

import com.thebytecloud.domain.Category;
import com.thebytecloud.domain.Customer;
import com.thebytecloud.repositories.CategoryRepository;
import com.thebytecloud.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        loadCustomers();

        loadCategories();

    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);


        System.out.println("Data Loaded = " + categoryRepository.count() );
    }


    public void loadCustomers() {

        Customer customer1 = new Customer();
        customer1.setFirstname("Joe");
        customer1.setLastname("Newman");

        Customer customer2 = new Customer();
        customer2.setFirstname("Michael");
        customer2.setLastname("Lachappele");

        Customer customer3 = new Customer();
        customer3.setFirstname("David");
        customer3.setLastname("Winter");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

    }

}
