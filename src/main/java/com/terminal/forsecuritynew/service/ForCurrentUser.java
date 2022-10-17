package com.terminal.forsecuritynew.service;

import com.terminal.entity.Users;
import org.springframework.security.core.context.SecurityContextHolder;

public class ForCurrentUser {
    public static Users currentUser() {
        return (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
