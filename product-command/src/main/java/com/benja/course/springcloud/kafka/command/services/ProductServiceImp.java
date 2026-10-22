package com.benja.course.springcloud.kafka.command.services;

import com.benja.course.springcloud.kafka.command.entities.Product;
import com.benja.course.springcloud.kafka.command.model.dto.ProductDto;
import com.benja.course.springcloud.kafka.command.repositories.ProductRepository;

public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto dto) {

        Product product = this.productRepository.save(new Product(null, dto.name(), dto.price()));
        return new ProductDto(product.getId(),product.getName(),product.getPrice());
    }
}
