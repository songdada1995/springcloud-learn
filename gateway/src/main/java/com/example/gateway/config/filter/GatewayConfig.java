package com.example.gateway.config.filter;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description 网关配置
 */
@Configuration
public class GatewayConfig {
    /**
     * 添加路由并给路由添加过滤器
     *
     * @param
     * @return
     */
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api_1/**")
                        .filters(f -> f.filter(new RequestTimeFilter())
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("lb://mycloud-consumer1")
                        .order(0)
                        .id("routes-mycloud-consumer1")
                )
                .build();
    }
}
