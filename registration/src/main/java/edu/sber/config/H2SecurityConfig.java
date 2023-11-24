package edu.sber.config;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Description.
 */
@Configuration
@EnableWebSecurity
public class H2SecurityConfig {

    /**
     * h2FilterChain.
     */
    @Bean
    @SneakyThrows
    public SecurityFilterChain h2FilterChain(HttpSecurity http) {
        http
                .securityMatcher("/**")
                .authorizeHttpRequests(
                        auth -> auth.requestMatchers(AntPathRequestMatcher.antMatcher("/**")).permitAll())
                .headers(headers -> headers.frameOptions().disable())
                .csrf(csrf -> csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/**")));
        return http.build();
    }
}
