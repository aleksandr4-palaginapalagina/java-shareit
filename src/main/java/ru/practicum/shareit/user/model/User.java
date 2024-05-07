package ru.practicum.shareit.user.model;

import lombok.*;


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

@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    @EqualsAndHashCode.Include
    private String email;
}
