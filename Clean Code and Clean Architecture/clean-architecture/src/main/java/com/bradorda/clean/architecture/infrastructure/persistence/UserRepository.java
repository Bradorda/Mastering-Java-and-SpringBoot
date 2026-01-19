package com.bradorda.clean.architecture.infrastructure.persistence;

import com.bradorda.clean.architecture.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
}
