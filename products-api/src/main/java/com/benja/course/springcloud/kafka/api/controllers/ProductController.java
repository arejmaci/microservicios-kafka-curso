package com.benja.course.springcloud.kafka.api.controllers;

import com.benja.course.springcloud.kafka.api.model.dto.ProductDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.benja.course.springcloud.kafka.api.services.ProductCommandService;

import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductCommandService productCommandService;

    public ProductController(ProductCommandService productCommandService) {
        this.productCommandService = productCommandService;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDto productDto) {
        productCommandService.sendCreate(productDto);
        return ResponseEntity.ok().body(Map.of("message", "Product creation command sent successfully"));
    }
}
