package org.practice.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
public class JwtSecurityConfig {
    private final JwtAuthorizationFilter jwtAuthorizationFilter;
    private final CsrfTokenLogger csrfTokenLogger;

    public JwtSecurityConfig(JwtAuthorizationFilter jwtAuthorizationFilter, CsrfTokenLogger csrfTokenLogger) {
        this.jwtAuthorizationFilter = jwtAuthorizationFilter;
        this.csrfTokenLogger = csrfTokenLogger;
    }

    public void configureJwtSecurity(HttpSecurity http) throws Exception {
        http.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterAfter(csrfTokenLogger, CsrfFilter.class);
        http.csrf(AbstractHttpConfigurer::disable);
    }
}
