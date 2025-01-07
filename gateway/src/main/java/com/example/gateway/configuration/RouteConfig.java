package com.example.gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

     @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("order-service", r -> r.path("/api/v1/order/**")
                        .uri("lb://ORDER-SERVICE"))
                .route("inventory-services", r -> r.path("/api/v1/inventory/**")
                        .uri("lb://INVENTORY-SERVICES"))
                .route("product-services", r -> r.path("/api/v1/product/**")
                        .uri("lb://PRODUCT-SERVICES"))
                .build();
    }
}
