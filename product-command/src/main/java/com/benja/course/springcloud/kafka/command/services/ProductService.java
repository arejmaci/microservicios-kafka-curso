package com.benja.course.springcloud.kafka.command.services;

import com.benja.course.springcloud.kafka.command.model.dto.ProductDto;

public interface ProductService {
    ProductDto createProduct(ProductDto dto);
}
