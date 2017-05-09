package com.boza.service.impl;

import com.boza.client.CustomerClient;
import com.boza.client.ProductClient;
import com.boza.service.OrderSevice;
import com.boza.swaggergen.model.CreateOrderRequest;
import com.boza.swaggergen.model.CustomerResponse;
import com.boza.swaggergen.model.Order;
import com.boza.swaggergen.model.ProductResponse;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderSevice {

    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private ProductClient productClient;

    @Override
    public Order createOrder(final CreateOrderRequest request) {
        final ProductResponse  productResponse = productClient.getProduct(request.getProductId());
        final CustomerResponse customerResponse = customerClient.getCustomer(request.getCustomerId());

        return createOrder(request, productResponse, customerResponse);
    }

    private Order createOrder(final CreateOrderRequest request, final ProductResponse  productResponse,
                              final CustomerResponse customerResponse) {
        final Order order = new Order();
        order.setAmount(request.getAmount());
        order.setOrderDate(new Date().toString());
        order.setCustomer(customerResponse.getCustomer());
        order.setProduct(productResponse.getProduct());

        return order;
    }
}
