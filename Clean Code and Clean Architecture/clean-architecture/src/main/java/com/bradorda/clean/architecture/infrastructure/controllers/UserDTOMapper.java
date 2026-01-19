package com.bradorda.clean.architecture.infrastructure.controllers;

import com.bradorda.clean.architecture.domain.entity.User;

public class UserDTOMapper {

    CreateUserResponse toResponse(User user){
        return new CreateUserResponse(user.username(),user.email());
    }

    public User toUser(CreateUserRequest request){
        return new User(request.username(),request.password(),request.email());
    }

}
