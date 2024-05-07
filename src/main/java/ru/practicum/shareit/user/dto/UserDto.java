package ru.practicum.shareit.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private int id;
    @NotEmpty
    private String name;
    @NotEmpty
    @Email(message = "неверно указан email")
    private String email;
}
