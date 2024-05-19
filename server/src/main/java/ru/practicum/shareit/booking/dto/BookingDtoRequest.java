package ru.practicum.shareit.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.shareit.booking.model.BookingStatus;

import java.time.LocalDateTime;

import static ru.practicum.shareit.booking.model.BookingStatus.WAITING;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDtoRequest {

    private Long itemId;
    private LocalDateTime start;
    private LocalDateTime end;
    private final BookingStatus status = WAITING;
}