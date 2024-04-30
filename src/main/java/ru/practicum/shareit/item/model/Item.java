package ru.practicum.shareit.item.model;

import lombok.*;
import ru.practicum.shareit.user.User;

/**
 * TODO Sprint add-controllers.
 */

@Data
@EqualsAndHashCode(of = {"id"})
public class Item {

    private int id;
    private String name;
    private String description;
    private Boolean available;
    private User owner;

}
