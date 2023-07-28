package com.example.springCloud.mapper;


import com.example.springCloud.entities.Product;

import java.util.List;

/**
 *
 */
//或者在啟動類上標識 @MapperScan
//@Mapper
public interface ProductMapper {

    Product findById(Long pid);

    List<Product> findAll();

    boolean addProduct(Product product);
}