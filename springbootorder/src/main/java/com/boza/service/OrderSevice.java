package com.boza.service;

import com.boza.swaggergen.model.CreateOrderRequest;
import com.boza.swaggergen.model.Order;

public interface OrderSevice {
    Order createOrder(CreateOrderRequest request);
}
