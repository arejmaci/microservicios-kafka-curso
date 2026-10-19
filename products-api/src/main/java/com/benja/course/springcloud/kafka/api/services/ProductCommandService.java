package com.benja.course.springcloud.kafka.api.services;

import com.benja.course.springcloud.kafka.api.model.dto.ProductDto;

public interface ProductCommandService {

    void sendCreate(ProductDto dto);
}
