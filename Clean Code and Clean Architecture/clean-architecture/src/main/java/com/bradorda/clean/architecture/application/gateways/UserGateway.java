package com.bradorda.clean.architecture.application.gateways;

import com.bradorda.clean.architecture.domain.entity.User;

public interface UserGateway {

    User createUser(User user);

}
