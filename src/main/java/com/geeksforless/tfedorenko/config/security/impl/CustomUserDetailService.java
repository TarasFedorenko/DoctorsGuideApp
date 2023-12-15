package com.geeksforless.tfedorenko.config.security.impl;

import com.geeksforless.tfedorenko.persistence.entity.user.User;
import com.geeksforless.tfedorenko.persistence.repository.user.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository<User> userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("invalid username or password"));
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRoleType().name()));
        return convertUser(user, authorities);
    }

    private org.springframework.security.core.userdetails.User convertUser(User user, Set<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.getEnable(),
                true,
                true,
                true,
                authorities
        );
    }
}