package com.boza.dao;

import com.boza.model.CustomerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerModel, Long>, CustomerRepositoryCustom {
}
