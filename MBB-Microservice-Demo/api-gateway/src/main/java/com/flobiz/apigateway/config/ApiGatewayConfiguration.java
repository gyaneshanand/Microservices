package com.flobiz.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator getewayRouter(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p.path("/get")
                        .filters(f -> f
                                .addRequestHeader("myCustomHeader", "someHeader")
                                .addRequestParameter("parma", "someParams"))
                        .uri("http://httpbin.org:80"))

                .route(p -> p.path("/platform-service/**")
                        .uri("lb://PLATFORM-SERVICE"))
                .route(p -> p.path("/payment-service/**")
                        .uri("lb://PAYMENT-SERVICE"))

                .build();
    }
}
