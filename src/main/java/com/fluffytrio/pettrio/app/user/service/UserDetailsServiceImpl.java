package com.fluffytrio.pettrio.app.user.service;

import com.fluffytrio.pettrio.app.user.domain.MyUserDetails;
import com.fluffytrio.pettrio.exception.UserNotFoundException;
import com.fluffytrio.pettrio.app.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public MyUserDetails loadUserByUsername(String username) {
        return userRepository.findByUserName(username)
                .map(u -> new MyUserDetails(u, Collections.singleton(new SimpleGrantedAuthority(u.getRole().getValue()))))
                .orElseThrow(() -> new UserNotFoundException(username));
    }
}
