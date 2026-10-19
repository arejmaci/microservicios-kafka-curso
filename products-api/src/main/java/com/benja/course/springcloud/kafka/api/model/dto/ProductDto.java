package com.benja.course.springcloud.kafka.api.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDto(@NotBlank String name, @NotNull @Min(10) Double price) {
}
