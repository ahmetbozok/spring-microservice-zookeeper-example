package com.boza.service.impl;

import com.google.common.collect.Lists;
import com.boza.dao.ProductRepository;
import com.boza.model.ProductModel;
import com.boza.service.ProductService;
import com.boza.swaggergen.model.Product;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productDao;

    @Override
    public Product createProduct(final Product product) {
        ProductModel productModel = modelMapper.map(product, ProductModel.class);
        productModel = productDao.addProduct(productModel);
        return modelMapper.map(productModel, Product.class);
    }

    @Override
    public Product getProduct(final long id) {
        ProductModel customerModel = productDao.findOne(id);
        return modelMapper.map(customerModel, Product.class);
    }

    @Override
    public List<Product> getProducts() {
        Iterable<ProductModel> productModels = productDao.findAll();
        List<Product> products = null;
        if (productModels != null) {
            products = Lists.newArrayList(productModels).stream()
            .map(c -> modelMapper.map(c, Product.class)).collect(Collectors.toList());
        }

        return products;
    }

}
