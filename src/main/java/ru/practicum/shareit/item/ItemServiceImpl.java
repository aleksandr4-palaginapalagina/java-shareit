package ru.practicum.shareit.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.exception.NotFoundException;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.user.User;
import ru.practicum.shareit.user.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;


    @Override
    public List<Item> getItems(int userId) {
        List<Item> itemList = itemRepository.getItemsByUser(userId);
        return itemList;
    }

    @Override
    public Item createItem(int userId, Item item) {
        User user = userRepository.get(userId);
        item.setOwner(user);
        itemRepository.createItem(userId, item);
        return item;
    }

    @Override
    public Item getItem(int itemId) {
        List<Item> itemList = itemRepository.getAllItems();
        for (Item item : itemList) {
            if (item.getId() == itemId) {
                return item;
            }
        }
        throw new NotFoundException("Не найден предмет c id-" + itemId);
    }

    @Override
    public List<Item> searchItems(String text) {
        List<Item> itemList = itemRepository.getAllItems();
        System.out.println(itemList);

        List<Item> itemListToResponce = new ArrayList<>();
        for (Item item : itemList) {
            if (item.getName().toLowerCase(Locale.ROOT).contains(text.toLowerCase()) || item.getDescription().toLowerCase(Locale.ROOT).contains(text.toLowerCase())) {
                if (item.getAvailable() == true) {
                    itemListToResponce.add(item);
                }
            }
        }
        System.out.println("После поиска");
        System.out.println(itemListToResponce);
        if (itemListToResponce.isEmpty()) {
            return Collections.emptyList();
        }
        return itemListToResponce;
    }

    @Override
    public Item updateItem(int userId, Item item) {
        User user = userRepository.get(userId);
        item.setOwner(user);
        item = itemRepository.update(userId, item);
        return item;
    }
}
