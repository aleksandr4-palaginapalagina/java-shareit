package ru.practicum.shareit.item.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.shareit.booking.dto.BookingDtoForItem;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class ItemInfo {

    private Long id;
    private String name;
    private String description;
    private Boolean available;
    private BookingDtoForItem lastBooking;
    private BookingDtoForItem nextBooking;
    private Set<CommentDtoResponse> comments = new HashSet<>();
}
