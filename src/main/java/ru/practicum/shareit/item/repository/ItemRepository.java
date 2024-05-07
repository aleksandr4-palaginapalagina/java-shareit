package ru.practicum.shareit.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.practicum.shareit.item.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByOwnerId(Long ownerId);

    Optional<Item> findByIdAndOwnerId(Long itemId, Long ownerId);

    @Query(" select i from Item i" +
            " where i.available = true" +
            " and (lower(i.name) like lower(concat('%', :text, '%'))" +
            " or lower(i.description) like lower(concat('%', :text, '%')))")
    List<Item> search(@Param("text") String text);
}
