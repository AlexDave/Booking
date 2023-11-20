package edu.sber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world.
 */

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class App {
    /**
     * Description.
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
