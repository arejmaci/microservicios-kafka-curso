package com.benja.course.springcloud.kafka.command.model;

public record Reply<T>(String status, String message, T body) {
}
