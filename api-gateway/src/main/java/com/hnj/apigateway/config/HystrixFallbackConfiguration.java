package com.hnj.apigateway.config;

import com.hnj.apigateway.config.fallback.GatewayClientResponse;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.reactive.ClientHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collections;

/*
 * Fallback configuration for Spring Cloud Gateway
 */

@Component
public class HystrixFallbackConfiguration {

    private static final String DEFAULT_MESSAGE = "Product information is not available.";

    public Mono<ClientHttpResponse> fallbackResponse(String route, Throwable cause) {
        HttpStatus status;

        if (cause instanceof NotFoundException) {
            status = HttpStatus.NOT_FOUND;
        } else if (cause instanceof IllegalStateException) {
            status = HttpStatus.SERVICE_UNAVAILABLE;
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return Mono.just((ClientHttpResponse) new GatewayClientResponse(status, DEFAULT_MESSAGE));
    }
}
