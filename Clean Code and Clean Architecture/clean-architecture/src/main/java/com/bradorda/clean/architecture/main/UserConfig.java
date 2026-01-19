package com.bradorda.clean.architecture.main;

import com.bradorda.clean.architecture.application.gateways.UserGateway;
import com.bradorda.clean.architecture.application.usecases.CreateUserInteractor;
import com.bradorda.clean.architecture.infrastructure.controllers.UserDTOMapper;
import com.bradorda.clean.architecture.infrastructure.gateways.UserEntityMapper;
import com.bradorda.clean.architecture.infrastructure.gateways.UserRepositoryGateway;
import com.bradorda.clean.architecture.infrastructure.persistence.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CreateUserInteractor createUserInteractor(UserGateway userGateway){
        return new CreateUserInteractor(userGateway);
    }

    @Bean
    UserGateway userGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        return new UserRepositoryGateway(userRepository, userEntityMapper);
    }

    @Bean
    UserEntityMapper userEntityMapper() {
        return new UserEntityMapper();
    }

    @Bean
    UserDTOMapper userDTOMapper() {
        return new UserDTOMapper();
    }

}
