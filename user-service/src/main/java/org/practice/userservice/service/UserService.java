package org.practice.userservice.service;

import org.practice.userservice.entity.User;
import org.practice.userservice.exception.NotFoundException;
import org.practice.userservice.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User loginUser) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        loginUser.setPassword(bCryptPasswordEncoder.encode(loginUser.getPassword()));
        return userRepository.save(loginUser);
    }


    public User findByName(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }
}
