package com.projects.mindfulwallet.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    /**
     * Defines the global CORS configuration for the application.
     * This is a best practice over using @CrossOrigin on each controller,
     * as it keeps the configuration in one central place.
     *
     * @return A WebMvcConfigurer with our CORS settings.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // This rule applies to all API endpoints under /api/
                registry.addMapping("/api/**")
                        // Allows requests from our Vite development server.
                        .allowedOrigins("http://localhost:5173")
                        // Specifies the allowed HTTP methods (GET, POST, etc.).
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        // Allows all headers in the request.
                        .allowedHeaders("*")
                        // Allows credentials (like cookies) to be sent. We'll need this for authentication later.
                        .allowCredentials(true);
            }
        };
    }
}