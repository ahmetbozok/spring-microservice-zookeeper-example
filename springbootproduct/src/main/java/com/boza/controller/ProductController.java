package com.boza.controller;

import com.boza.service.ProductService;
import com.boza.swaggergen.controller.ProductsApi;
import com.boza.swaggergen.model.Product;
import com.boza.swaggergen.model.ProductRequest;
import com.boza.swaggergen.model.ProductResponse;
import com.boza.swaggergen.model.ProductsResponse;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController extends ProductsApi {

    @Autowired
    private ProductService productService;

    @Override
    public ProductResponse createProduct(final ProductRequest createProductRequest, final HttpSession httpSession) {
        Product product = productService.createProduct(createProductRequest.getProduct());
        ProductResponse response = new ProductResponse();
        response.setProduct(product);
        return response;
    }

    @Override
    public ProductResponse getProduct(final String productId, final HttpSession httpSession) {
        Product product = productService.getProduct(new Long(productId));
        ProductResponse response = new ProductResponse();
        response.setProduct(product);
        return response;
    }

    @Override
    public ProductsResponse products(final HttpSession httpSession) {
        List<Product> products = productService.getProducts();
        ProductsResponse response = new ProductsResponse();
        response.setProducts(products);
        return response;
    }
}
