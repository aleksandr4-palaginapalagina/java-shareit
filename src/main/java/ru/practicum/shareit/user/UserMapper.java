package ru.practicum.shareit.user;

import ru.practicum.shareit.user.dto.UserDto;


public class UserMapper {

    public static UserDto toUserDto(User user) {
        if (user == null) {
            return null;
        }
        UserDto userDtoResponce = new UserDto();
        userDtoResponce.setId(user.getId());
        userDtoResponce.setName(user.getName());
        userDtoResponce.setEmail(user.getEmail());
        return userDtoResponce;

    }

    public static User toUser(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        return user;
    }


}
