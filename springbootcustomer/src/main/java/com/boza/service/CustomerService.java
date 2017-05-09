package com.boza.service;

import com.boza.swaggergen.model.Customer;
import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer getCustomer(long id);
    List<Customer> getCustomers();
}
