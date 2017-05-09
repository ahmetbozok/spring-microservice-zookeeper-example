package com.boza.controller;

import com.boza.service.OrderSevice;
import com.boza.swaggergen.controller.OrderApi;
import com.boza.swaggergen.model.CreateOrderRequest;
import com.boza.swaggergen.model.CreateOrderResponse;
import com.boza.swaggergen.model.Order;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController extends OrderApi{

    @Autowired
    private OrderSevice orderSevice;

    @Override
    public CreateOrderResponse createOrder(final CreateOrderRequest createOrderRequest, final HttpSession httpSession) {
        Order order = orderSevice.createOrder(createOrderRequest);
        CreateOrderResponse response = new CreateOrderResponse();
        response.setOrder(order);
        return response;
    }
}
