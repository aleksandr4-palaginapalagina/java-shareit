package ru.practicum.shareit.booking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import ru.practicum.shareit.booking.model.BookingStatus;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {

    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime start;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime end;
    private BookingStatus status;
    private Item item;
    private Booker booker;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Booker {
        private Long id;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Item {
        private Long id;
        private String name;
    }
}
