package com.club.service;

import com.club.domain.User;
import com.club.dto.UserDto;
import org.springframework.stereotype.Service;
import java.util.*;
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
        users.put(admin.getId(), admin);

        User client = new User();
        client.setId(idCounter.getAndIncrement());
        client.setName("Иван Иванов");
        client.setEmail("client@mail.ru");
        client.setRole("client");
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
        users.put(user.getId(), user);
        return convertToDto(user);
    }

    private UserDto convertToDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }
}