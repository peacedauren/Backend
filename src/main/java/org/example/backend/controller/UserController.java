package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.Dto.UserDTO;
import org.example.backend.service.UserService;
import org.example.backend.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public UUID create(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @GetMapping("/{id}")
    public UserDTO get(@PathVariable UUID id) {
        return userService.getById(id);
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return userService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        userService.deleteById(id);
    }
}
