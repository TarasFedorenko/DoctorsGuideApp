package com.geeksforless.tfedorenko.util;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.concurrent.atomic.AtomicBoolean;

public final class SecurityUtil {

    private SecurityUtil() {

    }

    public static String getUsername() {
        Authentication authentication = SecurityUtil.getAuthentication();
        User user = (User) authentication.getPrincipal();
        return user.getUsername();
    }

    public static boolean hasRole(String role) {
        Authentication authentication = SecurityUtil.getAuthentication();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        authentication.getAuthorities()
                .forEach(authority -> atomicBoolean.set(authority.getAuthority().equalsIgnoreCase(role)));
        return atomicBoolean.get();
    }

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
