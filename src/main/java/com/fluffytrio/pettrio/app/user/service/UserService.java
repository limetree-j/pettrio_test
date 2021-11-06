package com.fluffytrio.pettrio.app.user.service;

import com.fluffytrio.pettrio.app.user.domain.User;
import com.fluffytrio.pettrio.app.user.dto.SignUpDTO;
import com.fluffytrio.pettrio.app.user.enums.UserRole;
import com.fluffytrio.pettrio.app.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public User signUp(final SignUpDTO signUpDTO) {
        final User user = User.builder()
                .userName(signUpDTO.getUsername())
                .pw(signUpDTO.getPassword())
                .role(UserRole.ROLE_USER)
                .build();

        return userRepository.save(user);
    }

    public boolean isUsernameDuplicated(final String username) {
        return userRepository.existsByUserName(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
