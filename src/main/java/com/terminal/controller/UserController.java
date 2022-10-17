package com.terminal.controller;

import com.terminal.entity.Users;
import com.terminal.model.filter.UserFilterRequest;
import com.terminal.model.request.UserRequest;
import com.terminal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResponseEntity<Page<Users>> list(UserFilterRequest request) {
        return ResponseEntity.ok(userService.findByName(request));
    }

    @Transactional
    @PostMapping("/save")
    public ResponseEntity<Users> save(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.save(userRequest));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
