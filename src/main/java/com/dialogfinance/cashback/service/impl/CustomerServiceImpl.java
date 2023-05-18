package com.dialogfinance.cashback.service.impl;


import com.dialogfinance.cashback.entity.Customer;
import com.dialogfinance.cashback.repository.CustomerRepository;
import com.dialogfinance.cashback.requests.CustomerRequest;
import com.dialogfinance.cashback.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAllCustomer() {

        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(Long id) {
        Customer customerEntitys = customerRepository.findById(id).get();
        return customerEntitys;
    }
    @Override
    public Customer saveCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setId(customerRequest.getId());
        customer.setCustomerId(customerRequest.getCustomerId());
        customer.setDelFlag(customerRequest.getDelFlag());
        customer.setStatus(customerRequest.getStatus());
        customer.setCashbackId(customerRequest.getCashbackId());
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer CustomerEntity, Long id) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
