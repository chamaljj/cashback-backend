package com.dialogfinance.cashback.service;

import com.dialogfinance.cashback.entity.Customer;
import com.dialogfinance.cashback.requests.CustomerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {

    List<Customer> findAllCustomer();

    Customer findCustomerById(Long customerId);

    Customer saveCustomer(CustomerRequest customerRequest);

    Customer updateCustomer(Customer CustomerEntity, Long id);

    void deleteCustomer(Long customerId);
}
