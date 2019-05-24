package com.wyt.order.controller;

import com.wyt.order.client.ProductClient;
import com.wyt.order.config.RestTemplateConfig;
import com.wyt.order.dataobject.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        String response = restTemplate.getForObject("http://PRODUCT/msg",String.class);
        log.info("response :{}" , response);
        return response;
    }

    @GetMapping("/getProductList")
    public List<ProductInfo> getProductList() {
        return productClient.listForOrder(Arrays.asList("157875196366160022"));
    }
}
