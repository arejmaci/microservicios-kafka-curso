package com.benja.course.springcloud.kafka.command.handlers;

import com.benja.course.springcloud.kafka.command.model.Command;
import com.benja.course.springcloud.kafka.command.model.dto.ProductDto;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;
import org.slf4j.Logger;

@Configuration
public class ProductCommandConsumer {

    private static final Logger logger = LoggerFactory.getLogger(ProductCommandConsumer.class.getName());

    @Bean
    public Consumer<Command<ProductDto>> handlerCommands() {

        return command -> {
            logger.info("Received command: type={}, body={}", command.type(), command.body());
            // Here you can add logic to handle the command, e.g., save the product to a database
        };
    }
}
