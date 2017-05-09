package com.boza.dao.impl;

import com.boza.dao.CustomerRepositoryCustom;
import com.boza.model.CustomerModel;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CustomerModel addCustomer(final CustomerModel customer) {
        entityManager.persist(customer);
        return customer;
    }

//    @Override
//    public List<CustomerModel> getCustomers() {
//        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        final CriteriaQuery<CustomerModel> cq = cb.createQuery(CustomerModel.class);
//        final Root<CustomerModel> rootEntry = cq.from(CustomerModel.class);
//        final CriteriaQuery<CustomerModel> all = cq.select(rootEntry);
//        final TypedQuery<CustomerModel> allQuery = entityManager.createQuery(all);
//        return allQuery.getResultList();
//    }
}
