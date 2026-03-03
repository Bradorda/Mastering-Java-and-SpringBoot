package com.bradorda.spring_security_II.dtos.request;

import jakarta.validation.constraints.NotEmpty;

public record RegisterUserRequest(@NotEmpty(message = "Nome é obrigatório") String name,
                                  @NotEmpty(message = "E-mail obrigatório") String email,
                                  @NotEmpty(message = "senha é obrigatório") String password) {
}
