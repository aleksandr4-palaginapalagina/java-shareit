package ru.practicum.shareit.user.model;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;


import javax.persistence.*;


@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique", columnNames = "email")
        }
)
@ToString
@Getter
@Setter
@DynamicUpdate
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    private String name;

    @Column(nullable = false)
    private String email;
}
