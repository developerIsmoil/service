package com.terminal.service;

import com.terminal.entity.Users;
import com.terminal.model.filter.UserFilterRequest;
import com.terminal.model.request.UserRequest;
import org.springframework.data.domain.Page;

public interface UserService {
    Page<Users> findByName(UserFilterRequest request);

    Users save(UserRequest request);

    void delete(Long id);
}
