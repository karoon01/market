package com.yosypchuk.market.config.jwt;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@AllArgsConstructor
@PropertySource("classpath:security.properties")
public class JwtUtils {
}
