package org.example.backend.service;

import org.example.backend.Dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UUID save(UserDTO userDTO);
    UserDTO getById(UUID id);
    List<UserDTO> getAll();
    void deleteById(UUID id);
}
