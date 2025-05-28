package org.practice.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String name;
    private String accessToken;
    private String refreshToken;
}
