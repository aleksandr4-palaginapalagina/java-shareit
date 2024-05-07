package ru.practicum.shareit.item.model;

import lombok.*;
import ru.practicum.shareit.user.User;

import javax.persistence.*;


@Data
@EqualsAndHashCode(of = {"id"})
@Table(name = "items")
public class Item {


    private int id;

    private String name;
    private String description;
    private Boolean available;
    private User owner;


}
