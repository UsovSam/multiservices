package org.practice.security.config;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CsrfTokenLogger implements Filter {

    private final Logger LOGGER = LoggerFactory.getLogger(CsrfTokenLogger.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        CsrfToken token =
                (CsrfToken) servletRequest.getAttribute("_csrf");
        if(token != null) {
            LOGGER.info("CSRF token " + token.getToken());
        } else {
            LOGGER.info("CSRF token is null");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
