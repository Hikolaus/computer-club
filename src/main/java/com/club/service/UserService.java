package com.club.service;

import com.club.domain.User;
import com.club.dto.UserDto;
import org.springframework.stereotype.Service;
import java.util.*;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {
    private final Map<Long, User> users = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public UserService() {
        // Mock данные
        User admin = new User();
        admin.setId(idCounter.getAndIncrement());
        admin.setName("Администратор");
        admin.setEmail("admin@club.ru");
        admin.setRole("admin");
        admin.setDateRegistered(LocalDateTime.now());
        users.put(admin.getId(), admin);

        User client = new User();
        client.setId(idCounter.getAndIncrement());
        client.setName("Иван Иванов");
        client.setEmail("client@mail.ru");
        client.setRole("client");
        client.setDateRegistered(LocalDateTime.now());
        users.put(client.getId(), client);
    }

    public List<UserDto> getAllUsers() {
        return users.values().stream()
                .map(this::convertToDto)
                .toList();
    }

    public UserDto getUserById(Long id) {
        User user = users.get(id);
        return user != null ? convertToDto(user) : null;
    }

    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setId(idCounter.getAndIncrement());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setRole("client");
        user.setDateRegistered(LocalDateTime.now());
        users.put(user.getId(), user);
        return convertToDto(user);
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        User user = users.get(id);
        if (user != null) {
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            return convertToDto(user);
        }
        return null;
    }

    private UserDto convertToDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setDateRegistered(user.getDateRegistered());
        return dto;
    }
}