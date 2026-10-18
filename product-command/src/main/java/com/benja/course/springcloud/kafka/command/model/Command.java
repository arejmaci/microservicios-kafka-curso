package com.benja.course.springcloud.kafka.command.model;

public record Command<T>(String type, Long id, T body) {
}
