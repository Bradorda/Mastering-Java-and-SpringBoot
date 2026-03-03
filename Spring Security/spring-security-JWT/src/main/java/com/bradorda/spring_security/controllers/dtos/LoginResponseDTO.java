package com.bradorda.spring_security.controllers.dtos;

public record LoginResponseDTO(String accessToken, Long expiresIn) {

}
