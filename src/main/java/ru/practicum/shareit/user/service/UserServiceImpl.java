package ru.practicum.shareit.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.exception.NotFoundException;
import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.user.mapper.UserMapper;
import ru.practicum.shareit.user.model.User;
import ru.practicum.shareit.user.repository.UserRepository;

import javax.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static ru.practicum.shareit.user.mapper.UserMapper.toUserDto;
import static ru.practicum.shareit.utils.Message.ADD_MODEL;
import static ru.practicum.shareit.utils.Message.MODEL_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public UserDto addModel(UserDto userDto) {
        User user = userRepository.save(UserMapper.toUser(userDto));
        log.info(ADD_MODEL.getMessage(), user);
        return toUserDto(user);
    }

    @Transactional
    @Override
    public UserDto updateModel(long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MODEL_NOT_FOUND.getMessage() + id));
        if (userDto.getEmail() != null && !user.getEmail().equals(userDto.getEmail())) {
            user.setEmail(userDto.getEmail());
        }
        if (userDto.getName() != null) {
            user.setName(userDto.getName());
        }

        userRepository.save(user);
        return toUserDto(user);
    }

    @Override
    public UserDto findModelById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(MODEL_NOT_FOUND.getMessage() + id));
        return toUserDto(user);
    }

    @Override
    public List<UserDto> getAllModels() {
        return userRepository.findAll().stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteModelById(long id) {
        userRepository.deleteById(id);
    }
}
