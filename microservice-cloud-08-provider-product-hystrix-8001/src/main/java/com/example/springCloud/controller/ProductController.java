package com.example.springCloud.controller;


import com.example.springCloud.entities.Product;
import com.example.springCloud.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Product product) {
        return productService.add(product);
    }

    @HystrixCommand(fallbackMethod = "getFallback")
    @RequestMapping(value = "/product/get/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable("id") Long id) {
        Product product = productService.get(id);
        // 模擬異常
        if (product == null) {
            throw new RuntimeException("ID=" + id + "無效");
        }
        return product;
    }
    //當get方法出現異常時，則會調用此方法. 注意此方法的返回值，參數列表與原方法一致
    public Product getFallback(@PathVariable("id") Long id) {
        return new Product(id,
                "ID=" + id + "無效--@HystrixCommand", "無有效數據庫");
    }


    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public List<Product> list() {
        return productService.list();
    }


}
