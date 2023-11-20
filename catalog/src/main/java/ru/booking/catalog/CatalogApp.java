package ru.booking.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class CatalogApp {
    public static void main(String[] args) {
        SpringApplication.run(CatalogApp.class, args);
    }
}
