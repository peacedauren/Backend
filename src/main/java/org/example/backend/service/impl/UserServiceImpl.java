package org.example.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.backend.Dto.UserDTO;
import org.example.backend.entities.User;
import org.example.backend.repository.UserRepository;
import org.example.backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UUID save(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        user.setEmail(userDTO.getEmail());

        return userRepository.saveAndFlush(user).getId();
    }

    @Override
    public UserDTO getById(UUID id) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null) {
            return null;
        }

        return UserDTO.builder().age(user.getAge()).name(user.getName()).email(user.getEmail()).build();
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream().map(user -> UserDTO.builder().age(user.getAge()).name(user.getName()).email(user.getEmail()).build()).toList();
    }

    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }
}
