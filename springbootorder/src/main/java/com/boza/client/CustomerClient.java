package com.boza.client;

import com.boza.swaggergen.model.CustomerResponse;
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
public class CustomerClient {

    @Autowired
    private TheClient theClient;

    /**
     * Create a REST-ful client to connect to the "customer" service available on
     * ZooKeeper.
     *
     */
    @FeignClient(name = "customer")
    interface TheClient {
        @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.GET)
        @ResponseBody
        CustomerResponse getCustomer(@PathVariable("customerId") Integer customerId);
    }

    /**
     * Initiate call to product.
     *
     * @param customerId
     * @return the response
     */
    public CustomerResponse getCustomer(Integer customerId) {
        return theClient.getCustomer(customerId);
    }
}
