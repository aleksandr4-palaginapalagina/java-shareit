package ru.practicum.shareit.user.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserDto {

    private Long id;
    private String name;
    @NotBlank
    @Email
    @EqualsAndHashCode.Include
    private String email;
}
