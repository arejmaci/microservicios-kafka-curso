package com.benja.course.springcloud.kafka.command.model.mapper;

import com.benja.course.springcloud.kafka.command.entities.Product;
import com.benja.course.springcloud.kafka.command.model.dto.ProductDto;

public final class Mappers {
    private Mappers(){}

    static public ProductDto toDto(Product product){
        return new ProductDto(product.getId(),product.getName(),product.getPrice());
    }

    static public Product toEntity(ProductDto productDto){
        return new Product(productDto.id(),productDto.name(),productDto.price());
    }
}
