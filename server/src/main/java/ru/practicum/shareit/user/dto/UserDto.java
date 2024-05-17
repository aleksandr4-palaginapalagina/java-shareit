package ru.practicum.shareit.user.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserDto {

    private Long id;
    private String name;
    @EqualsAndHashCode.Include
    private String email;
}
