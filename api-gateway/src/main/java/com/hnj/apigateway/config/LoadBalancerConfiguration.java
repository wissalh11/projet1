package com.hnj.apigateway.config;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadBalancerConfiguration {

    @Bean
    public ServiceInstanceListSupplier discoveryClientServiceInstanceListSupplier(ApplicationContext context) {
        // Utilisation du fournisseur basé sur le client de découverte (Eureka, Consul, etc.)
        return ServiceInstanceListSupplier.builder()
                .withDiscoveryClient()
                .build((ConfigurableApplicationContext) context);
    }
}
