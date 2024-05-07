package ru.practicum.shareit.item.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
public class ItemDto {

    private int id;
    @NotBlank
    private String name;
    @NotEmpty
    private String description;
    @NotNull
    private Boolean available;

}
