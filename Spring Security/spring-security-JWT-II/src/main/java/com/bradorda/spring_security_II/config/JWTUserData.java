package com.bradorda.spring_security_II.config;

import lombok.Builder;

@Builder
public record JWTUserData(Long userId,String email) {

}
