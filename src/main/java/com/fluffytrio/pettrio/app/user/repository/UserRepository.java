package com.fluffytrio.pettrio.app.user.repository;

import com.fluffytrio.pettrio.app.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserNameAndPw(String username, String password);

    Optional<User> findByUserName(String username);

    boolean existsByUserName(String username);
}
