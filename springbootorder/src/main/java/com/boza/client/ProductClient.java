package com.boza.client;

import com.boza.swaggergen.model.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@EnableFeignClients
@EnableDiscoveryClient
public class ProductClient {

    @Autowired
    private TheClient theClient;

    /**
     * Create a REST-ful client to connect to the "product" service available on
     * ZooKeeper.
     *
     */
    @FeignClient(name = "product")
    interface TheClient {
        @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
        @ResponseBody
        ProductResponse getProduct(@PathVariable("productId") Integer productId);
    }

    /**
     * Initiate call to product.
     *
     * @param productId
     * @return the response
     */
    public ProductResponse getProduct(Integer productId) {
        return theClient.getProduct(productId);
    }
}
