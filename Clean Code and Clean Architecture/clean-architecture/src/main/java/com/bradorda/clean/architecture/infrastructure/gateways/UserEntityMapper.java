package com.bradorda.clean.architecture.infrastructure.gateways;

import com.bradorda.clean.architecture.domain.entity.User;
import com.bradorda.clean.architecture.infrastructure.persistence.UserEntity;

public class UserEntityMapper {

    UserEntity toEntity(User userDomainObj){
        return new UserEntity(userDomainObj.username(), userDomainObj.email(), userDomainObj.password());
    }

    User toDomainObj(UserEntity userEntity){
        return new User(userEntity.getUsername(), userEntity.getEmail(), userEntity.getPassword());
    }

}
