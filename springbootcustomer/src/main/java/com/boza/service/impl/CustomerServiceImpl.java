package com.boza.service.impl;

import com.google.common.collect.Lists;
import com.boza.dao.CustomerRepository;
import com.boza.model.CustomerModel;
import com.boza.service.CustomerService;
import com.boza.swaggergen.model.Customer;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepository customerDao;

    @Override
    public Customer createCustomer(final Customer customer) {
        CustomerModel customerModel = modelMapper.map(customer, CustomerModel.class);
        customerModel = customerDao.addCustomer(customerModel);
        return modelMapper.map(customerModel, Customer.class);
    }

    @Override
    public Customer getCustomer(final long id) {
        CustomerModel customerModel = customerDao.findOne(id);
        return modelMapper.map(customerModel, Customer.class);
    }

    @Override
    public List<Customer> getCustomers() {
        Iterable<CustomerModel> customerModels = customerDao.findAll();
        List<Customer> customers = null;
        if (customerModels != null) {
            customers = Lists.newArrayList(customerModels).stream()
            .map(c -> modelMapper.map(c, Customer.class)).collect(Collectors.toList());
        }

        return customers;
    }
}
