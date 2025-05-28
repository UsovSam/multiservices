package org.practice.userservice.service;

import org.practice.userservice.entity.User;
import org.practice.userservice.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byEmail = userRepository.findByName(username);

        return org.springframework.security.core.userdetails.User.builder()
                .username(byEmail.getName())
                .password(byEmail.getPassword())
                .roles(new String[]{"ADMIN"})
                .build();

    }
}
