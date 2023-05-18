package com.dialogfinance.cashback.controller;

import com.dialogfinance.cashback.entity.Cashback;
import com.dialogfinance.cashback.entity.Customer;
import com.dialogfinance.cashback.exception.ResourceNotFoundException;
import com.dialogfinance.cashback.repository.CustomerRepository;
import com.dialogfinance.cashback.requests.CustomerRequest;
import com.dialogfinance.cashback.service.CustomerService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> findAllCustomer(){
        return customerService.findAllCustomer();
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<?> findCustomerById(@PathVariable("customerId") Long customerId){
        Customer customerEntity = customerService.findCustomerById(customerId);
        return ResponseEntity.ok(customerEntity);
    }

    @PostMapping("/customers")
    public Map<String, Object> saveCustomer(@RequestBody CustomerRequest customerRequest) {
        Map<String, Object> response = new HashMap<>();
        try {
            log.info("Save a customer wise cashback Successfully ...");

            Customer customer = customerService.saveCustomer(customerRequest);
            response.put("STATUS", "SUCCESS");
            response.put("MESSAGE", "YOU ADDED SUCCESSFULLY");
            response.put("DATA", customer);
            log.info("Add new Customer Details : "+customer);

        } catch (Exception e) {
            log.error("Save a customer wise cashback Unsuccessfully ..."+e);

            response.put("STATUS", "FAILED");
            response.put("MESSAGE", e);
        }
        return response;
    }

    @PutMapping("/customers/{id}")
    @PreAuthorize("hasRole('Super Admin') or hasRole('Admin')")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {

        log.info("Update customer wise cashback Successfully with id: " + id);

        Customer updateCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id: " + id));
        updateCustomer.setCustomerId(customerDetails.getCustomerId());
        updateCustomer.setDelFlag(customerDetails.getDelFlag());
        updateCustomer.setStatus(customerDetails.getStatus());
        updateCustomer.setCashbackId(customerDetails.getCashbackId());
        customerRepository.save(updateCustomer);

        log.info("Update Customer id : " +id+ " Details : "+updateCustomer);

        return ResponseEntity.ok(updateCustomer);
    }

    @DeleteMapping("/customers/{id}")
   @PreAuthorize("hasRole('Super Admin')")
    public void deleteCustomer(@PathVariable("id") Long id){

        Optional<Customer> deleteCustomer= customerRepository.findById(id);
        log.info("Deleted a customer wise cashback Successfully  {}",deleteCustomer.toString());

        customerService.deleteCustomer(id);
    }
}
