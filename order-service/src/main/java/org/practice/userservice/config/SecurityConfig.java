package org.practice.userservice.config;

import org.practice.security.config.JwtSecurityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtSecurityConfig jwtSecurityConfig;

    public SecurityConfig(JwtSecurityConfig jwtSecurityConfig) {
        this.jwtSecurityConfig = jwtSecurityConfig;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        jwtSecurityConfig.configureJwtSecurity(http);

        http.authorizeHttpRequests(c -> c
                .anyRequest().authenticated());

        return http.build();
    }
}
