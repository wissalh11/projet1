package com.hnj.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration for Cross-Origin Resource Sharing (CORS)
 */
@Configuration
public class WebConfiguration {

    /**
     * Enables Cross-Origin Resource Sharing (CORS) for the entire application.
     * More info: http://docs.spring.io/spring/docs/current/spring-framework-reference/html/cors.html
     *
     * @return a WebMvcConfigurer instance that configures CORS mappings
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permet tous les chemins
                        .allowedOrigins("*") // Permet toutes les origines (vous pouvez restreindre si nécessaire)
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Méthodes HTTP autorisées
                        .allowedHeaders("*") // Autorise tous les en-têtes
                        .allowCredentials(true); // Permet l'envoi de cookies d'authentification
            }
        };
    }
}
