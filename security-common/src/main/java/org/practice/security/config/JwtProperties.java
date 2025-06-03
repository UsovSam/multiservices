package org.practice.security.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    private String secretKey = "DEFAULT=ZGVmYXVsdFNlY3JldEtleVRoYXRTaG91bGRCZU92ZXJyaWRkZW5JblByb2R1Y3Rpb24=";

}