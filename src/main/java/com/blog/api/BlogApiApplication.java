/**
 * This class represents the main entry point for the Blog API application.
 * It contains the configuration and initialization of the Spring Boot application.
 *
 * @Author Nishant
 */
package com.blog.api;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogApiApplication {

    /**
     * The main method that starts the Spring Boot application.
     *
     * @param args The command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(BlogApiApplication.class, args);
    }

    /**
     * Creates and configures a ModelMapper bean, which is used for object mapping.
     *
     * @return A configured ModelMapper instance.
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
