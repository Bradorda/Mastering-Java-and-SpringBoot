package com.bradorda.spring_security.repositories;

import com.bradorda.spring_security.entities.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet,Long> {

}
