package com.boza.dao.impl;

import com.boza.dao.ProductRepositoryCustom;
import com.boza.model.ProductModel;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ProductModel addProduct(final ProductModel product) {
        entityManager.persist(product);
        return product;
    }

}
