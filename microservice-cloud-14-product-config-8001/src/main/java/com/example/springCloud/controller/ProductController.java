package com.example.springCloud.controller;



import com.example.springCloud.entities.Product;
import com.example.springCloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RefreshScope
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Value("${emp.name}")
    private String name;

    @GetMapping("/hello")
    public String hello() {
        return name;
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Product product) {
        return productService.add(product);
    }

    @RequestMapping(value = "/product/get/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable("id") Long id) {
        Product returnData = productService.get(id);

        System.out.println("id="+id+",value="+returnData.getProductName());
        return returnData;
    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public List<Product> list() {
        return productService.list();
    }

}
