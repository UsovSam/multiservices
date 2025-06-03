package org.practice.security.config;

import org.practice.security.util.JwtUtil;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.practice.security")
@EnableConfigurationProperties(JwtProperties.class)
public class JwtSecurityAutoConfiguration {

    @Bean
    public JwtUtil jwtUtil(JwtProperties jwtProperties) {
        return new JwtUtil(jwtProperties);
    }

    @Bean
    public CsrfTokenLogger csrfTokenLogger() {
        return new CsrfTokenLogger();
    }

    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilter(JwtUtil jwtUtil) {
        return new JwtAuthorizationFilter(jwtUtil);
    }

    @Bean
    public JwtSecurityConfig jwtSecurityConfig(JwtAuthorizationFilter jwtAuthorizationFilter, CsrfTokenLogger csrfTokenLogger) {
        return new JwtSecurityConfig(jwtAuthorizationFilter, csrfTokenLogger);
    }
}
