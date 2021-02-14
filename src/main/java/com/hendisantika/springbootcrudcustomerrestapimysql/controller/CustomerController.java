package com.hendisantika.springbootcrudcustomerrestapimysql.controller;

import com.hendisantika.springbootcrudcustomerrestapimysql.entity.Customer;
import com.hendisantika.springbootcrudcustomerrestapimysql.exception.ResourceNotFoundException;
import com.hendisantika.springbootcrudcustomerrestapimysql.repository.CustomerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-crud-customer-rest-api-mysql
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 15/02/21
 * Time: 05.57
 */
@Log4j2
@RestController
@RequestMapping("api/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Customer save(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping
    public Page<Customer> getAllData(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @GetMapping(value = "{customerId}")
    public Customer findByCustomerId(@PathVariable Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer " +
                "[customerId=" + customerId + "] can't be found"));
    }

    @PutMapping(value = "{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer newCustomer) {
        return customerRepository.findById(customerId).map(customer -> {
            customer.setName(newCustomer.getName());
            customer.setPhone(newCustomer.getPhone());
            customerRepository.save(customer);
            return ResponseEntity.ok(customer);
        }).orElseThrow(() -> new ResourceNotFoundException("Customer [customerId=" + customerId + "] can't be found"));
    }

    @DeleteMapping(value = "{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
        return customerRepository.findById(customerId).map(customer -> {
                    customerRepository.delete(customer);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(() -> new ResourceNotFoundException("Customer [customerId=" + customerId + "] can't be found"));
    }

}
