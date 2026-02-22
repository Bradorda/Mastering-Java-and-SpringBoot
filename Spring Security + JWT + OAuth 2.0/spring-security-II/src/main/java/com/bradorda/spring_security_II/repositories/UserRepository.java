package com.bradorda.spring_security_II.repositories;

import com.bradorda.spring_security_II.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<UserDetails> findUserByEmail(String username);

}
