package ru.practicum.shareit.item;

import ru.practicum.shareit.item.model.Item;

import java.util.List;

public interface ItemRepository {

    Item createItem(int userId, Item item);

    Item update(int userId, Item item);

    List<Item> getItemsByUser(int userId);

    List<Item> getAllItems();
}
