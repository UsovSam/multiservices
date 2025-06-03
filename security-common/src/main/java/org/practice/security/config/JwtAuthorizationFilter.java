package org.practice.security.config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.practice.security.util.JwtUtil;
import org.practice.security.util.Params;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(JwtAuthorizationFilter.class);
    private final JwtUtil jwtUtil;

    public JwtAuthorizationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws IOException, ServletException {

        String authorization = request.getHeader("Authorization");
        if (authorization == null || !authorization.startsWith(Params.BEARER_PREFIX.getValue())) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authorization.substring(Params.BEARER_PREFIX.getValue().length());
        logger.info("JWT token: {}", token);
        if (!jwtUtil.isValid(token)) {
            logger.info("JWT token is not valid");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Jws<Claims> claimsJws = jwtUtil.parseToken(token);
        String username = String.valueOf(claimsJws.getPayload().get("username"));
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, "", new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        logger.info("JWT token username: {}", username);
        filterChain.doFilter(request, response);
    }

}
