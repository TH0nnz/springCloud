package com.example.springCloud.service;



import com.example.springCloud.entities.Product;

import java.util.List;

/**
 */

public interface ProductService {

    boolean add(Product product);

    Product get(Long id);

    List<Product> list();

}
