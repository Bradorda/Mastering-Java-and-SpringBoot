package com.bradorda.clean.architecture.infrastructure.gateways;

import com.bradorda.clean.architecture.application.gateways.UserGateway;
import com.bradorda.clean.architecture.domain.entity.User;
import com.bradorda.clean.architecture.infrastructure.persistence.UserEntity;
import com.bradorda.clean.architecture.infrastructure.persistence.UserRepository;

public class UserRepositoryGateway implements UserGateway {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User createUser(User userDomainObj) {
        UserEntity userEntity = userEntityMapper.toEntity(userDomainObj);
        UserEntity savedEntity = userRepository.save(userEntity);

        return userEntityMapper.toDomainObj(savedEntity);
    }
}
