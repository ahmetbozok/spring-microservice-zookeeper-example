package com.boza.dao;

import com.boza.model.ProductModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Long>, ProductRepositoryCustom {
}
