package ru.practicum.shareit.user;

import lombok.*;


@Data
@EqualsAndHashCode(of = {"id"})
public class User {


    private int id;

    private String name;

    private String email;


}
