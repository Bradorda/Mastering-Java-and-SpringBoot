package com.bradorda.spring_security_II.dtos.request;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequestDTO(@NotEmpty(message = "Email é obrigatório") String email,
                              @NotEmpty(message ="Senha é obrigatório") String senha) {
}
