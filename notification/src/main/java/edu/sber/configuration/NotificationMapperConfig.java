package edu.sber.configuration;

import edu.sber.mapper.NotificationDetailToNotificationMapper;
import edu.sber.mapper.NotificationDetailToNotificationMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationMapperConfig {
    @Bean
    NotificationDetailToNotificationMapper getMapper() {
        return new NotificationDetailToNotificationMapperImpl();
    }
}
