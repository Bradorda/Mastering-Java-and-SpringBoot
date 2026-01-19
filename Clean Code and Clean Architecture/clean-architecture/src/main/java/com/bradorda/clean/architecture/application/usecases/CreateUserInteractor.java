package com.bradorda.clean.architecture.application.usecases;

import com.bradorda.clean.architecture.application.gateways.UserGateway;
import com.bradorda.clean.architecture.domain.entity.User;

public class CreateUserInteractor {

    private UserGateway userGateway;

    public CreateUserInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User createUser(User user){
        return userGateway.createUser(user);
    }

}
