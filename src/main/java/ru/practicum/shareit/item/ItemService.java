package ru.practicum.shareit.item;

import ru.practicum.shareit.item.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getItems(int userId);

    Item createItem(int userId, Item item);

    Item getItem(int itemId);

    List<Item> searchItems(String text);

    Item updateItem(int userId, Item item);

}
