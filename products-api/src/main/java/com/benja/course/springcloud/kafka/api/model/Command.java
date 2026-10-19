package com.benja.course.springcloud.kafka.api.model;

public record Command<T>(String type, Long id, T body) {
}
