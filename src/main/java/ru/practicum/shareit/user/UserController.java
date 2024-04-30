package ru.practicum.shareit.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.user.dto.UserDto;


import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO Sprint add-controllers.
 */
@RestController
@Slf4j
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers() {
        List<User> userList = userService.getAll();
        List<UserDto> userDtoList = userList.stream().map(UserMapper::toUserDto).collect(Collectors.toList());
        log.info("Запрошены все пользователи");
        System.out.println(userDtoList);
        return userDtoList;
    }

    @PostMapping
    public UserDto createUsers(@Validated @RequestBody UserDto userDto) {
        User user = UserMapper.toUser(userDto);
        user = userService.createUser(user);
        log.info("Пользователь создан {}", user);
        userDto = UserMapper.toUserDto(user);

        return userDto;
    }

    @PatchMapping("/{userId}")
    public UserDto updateUsers(@PathVariable int userId, @RequestBody UserDto userDto) {
        log.info("Пользователь обновлен {}", userDto);
        User user = UserMapper.toUser(userDto);
        user.setId(userId);
        return UserMapper.toUserDto(userService.updateUser(user));
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable int id) {
        log.info("Запрошен пользователь с id - {}", id);
        User user = userService.getUserById(id);
        return UserMapper.toUserDto(user);
    }

    @DeleteMapping("/{userId}")
    public UserDto deleteUser(@PathVariable int userId) {
        log.info("Пользователь {} удален", userId);
        User user = userService.deleteUser(userId);
        return UserMapper.toUserDto(user);
    }


}
