package ru.practicum.shareit.item;


import org.springframework.stereotype.Repository;
import ru.practicum.shareit.exception.NotFoundException;
import ru.practicum.shareit.item.model.Item;

import java.util.*;

@Repository
public class ItemRepositoryImp implements ItemRepository {

    private Map<Integer, List<Item>> itemRepo = new HashMap<>();
    private int generateIdByItem = 0;

    @Override
    public Item createItem(int userId, Item item) {
        item.setId(++generateIdByItem);
        List<Item> itemList;
        if (itemRepo.get(userId) == null) {
            itemList = new ArrayList<>();
        } else {
            itemList = itemRepo.get(userId);
        }
        itemList.add(item);
        itemRepo.put(userId, itemList);
        System.out.println(item);
        return item;
    }

    @Override
    public Item update(int userId, Item item) {
        if (!itemRepo.containsKey(userId)) {
            throw new NotFoundException("У этого пользователя нет вещей");
        }
        List<Item> itemList = itemRepo.get(userId);
        int indexToReplace = itemList.indexOf(item);
        if (indexToReplace != -1) {
            Item itemFromList = itemList.get(indexToReplace);
            if (item.getName() != null) {
                itemFromList.setName(item.getName());
            }
            if (item.getDescription() != null) {
                itemFromList.setDescription(item.getDescription());
            }
            if (item.getAvailable() != null) {

                itemFromList.setAvailable(item.getAvailable());
            }
            itemList.set(indexToReplace, itemFromList);
            System.out.println(itemFromList);
            itemRepo.put(userId, itemList);
            return itemFromList;
        } else {
            throw new NotFoundException("Не найден предмет  " + item);
        }
    }

    @Override
    public List<Item> getItemsByUser(int userId) {
        if (!itemRepo.containsKey(userId)) {
            throw new NotFoundException("Не найдены вещи у пользователя с id " + userId);
        }
        List<Item> itemList = itemRepo.get(userId);
        return itemList;
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> itemList = new ArrayList<>();
        for (Integer integer : itemRepo.keySet()) {
            itemList.addAll(itemRepo.get(integer));
        }
        return itemList;
    }


}
