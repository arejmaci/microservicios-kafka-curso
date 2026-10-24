package com.benja.course.springcloud.kafka.command.handlers;

import com.benja.course.springcloud.kafka.command.model.Command;
import com.benja.course.springcloud.kafka.command.model.Reply;
import com.benja.course.springcloud.kafka.command.model.dto.ProductDto;
import com.benja.course.springcloud.kafka.command.services.ProductService;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Function;

import org.slf4j.Logger;

@Configuration
public class ProductCommandConsumer {

    private final ProductService productService;
    private static final Logger logger = LoggerFactory.getLogger(ProductCommandConsumer.class.getName());

    public ProductCommandConsumer(ProductService productService) {
        this.productService = productService;
    }

    @Bean
    public Function<Command<ProductDto>, Reply<?>> handlerCommands() {

        return command -> {
            String commandType = command.type() == null ? "null" : command.type().toUpperCase();
            switch (commandType) {
                case "CREATE" -> {
                    if (command.body() == null) {
                        logger.warn("Received CREATE command with null body");
                        return new Reply<>("ERROR", "Empty Body",null);
                    } else {
                        ProductDto productDto = command.body();
                        ProductDto productSave = productService.createProduct(command.body());
                        logger.info("Creating product name={}, price={}", productSave.name(),productSave.price());
                        return new Reply<>("SUCCESS", "Created Product",productSave);
                    }
                }
//                case "UPDATE" -> {
//                    if (command.body() == null) {
//                        logger.warn("Received UPDATE command with null body");
//                    } else {
//                        logger.info("Updating product: {}", command.body());
//                    }
//                }
//                case "DELETE" -> {
//                    if (command.body() == null) {
//                        logger.warn("Received DELETE command with null body");
//                    } else {
//                        logger.info("Deleting product: {}", command.body());
//                    }
//                }
//                case "READ_ALL" -> {
//                    logger.info("Reading all products");
//                }
//                case "READ_BY_ID" -> {
//                    if (command.body() == null) {
//                        logger.warn("Received READ_BY_ID command with null body");
//                    } else {
//                        logger.info("Reading product by ID: {}", command.body());
//                    }
//                }
                default -> {
                    logger.warn("Unknown command type: {}", command.type());
                    return new Reply<>("ERROR", "Unknown command type",null);
                }
            }
        };
    }
}
