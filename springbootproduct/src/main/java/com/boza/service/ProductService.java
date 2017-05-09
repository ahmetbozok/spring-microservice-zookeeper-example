package com.boza.service;

import com.boza.swaggergen.model.Product;
import java.util.List;

public interface ProductService {
    Product createProduct(Product customer);
    Product getProduct(long id);
    List<Product> getProducts();
}
