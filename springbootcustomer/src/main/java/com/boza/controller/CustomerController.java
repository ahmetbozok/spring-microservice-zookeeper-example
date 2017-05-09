package com.boza.controller;

import com.boza.service.CustomerService;
import com.boza.swaggergen.controller.CustomersApi;
import com.boza.swaggergen.model.Customer;
import com.boza.swaggergen.model.CustomerRequest;
import com.boza.swaggergen.model.CustomerResponse;
import com.boza.swaggergen.model.CustomersResponse;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController extends CustomersApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    /**
     * Returns a list of customer for the logged in user.
     *
     * @return CustomersResponse
     */
    public CustomersResponse customers(final HttpSession httpSession) {
        List<Customer> customers = customerService.getCustomers();
        CustomersResponse response = new CustomersResponse();
        response.setCustomers(customers);
        return response;
    }

    @Override
    public CustomerResponse getCustomer(final String userId, final HttpSession httpSession) {
        Customer customer = customerService.getCustomer(new Long(userId));
        CustomerResponse response = new CustomerResponse();
        response.setCustomer(customer);
        return response;
    }

    /**
     * Create a new customer and return.
     *
     * @return CreateCustomerResponse
     */
    public CustomerResponse createCustomer(final CustomerRequest customerRequest,
                                           final HttpSession httpSession) {
        Customer customer = customerService.createCustomer(customerRequest.getCustomer());
        CustomerResponse response = new CustomerResponse();
        response.setCustomer(customer);
        return response;
    }
}
