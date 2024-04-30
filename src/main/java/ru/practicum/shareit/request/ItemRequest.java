package ru.practicum.shareit.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.practicum.shareit.user.User;

import java.time.LocalDateTime;

/**
 * TODO Sprint add-item-requests.
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@SuperBuilder
public class ItemRequest {

    private int id;
    private String description;
    private User requestor;
    private LocalDateTime created;
}
