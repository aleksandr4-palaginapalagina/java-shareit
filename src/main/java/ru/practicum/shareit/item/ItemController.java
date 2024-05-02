package ru.practicum.shareit.item;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.model.Item;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@Slf4j
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public List<ItemDto> getItems(@RequestHeader("X-Sharer-User-Id") int userId) {
        log.info("Get items by userId = {}", userId);
        List<Item> itemList = itemService.getItems(userId);
        return itemList.stream().map(ItemMapper::toItemDto).collect(Collectors.toList());
    }

    @PostMapping
    public ItemDto createItem(@RequestHeader("X-Sharer-User-Id") int userId, @Valid @RequestBody ItemDto itemDto) {

        Item item = ItemMapper.toItem(itemDto);
        item = itemService.createItem(userId, item);
        log.info("Create item by userId - {}, item = {}", userId, item);
        ItemDto itemDtoToResponce = ItemMapper.toItemDto(item);
        return itemDtoToResponce;
    }

    @PatchMapping("/{itemId}")
    public ItemDto updateItem(@PathVariable int itemId, @RequestHeader("X-Sharer-User-Id") int userId, @RequestBody ItemDto itemDto) {
        Item item = ItemMapper.toItem(itemDto);
        item.setId(itemId);
        log.info("Update item by userId - {}, item = {}", userId, item);
        item = itemService.updateItem(userId, item);
        return ItemMapper.toItemDto(item);
    }

    @GetMapping("/{itemId}")
    public ItemDto getItem(@PathVariable int itemId) {
        log.info("Get item itemId={}", itemId);
        return ItemMapper.toItemDto(itemService.getItem(itemId));
    }

    @GetMapping("/search")
    public List<ItemDto> search(@RequestParam(name = "text") String text) {
        log.info("Search item by text = {}", text);
        if (text == null || text.isBlank()) {
            return Collections.emptyList();
        }
        List<Item> itemList = itemService.searchItems(text);
        return itemList.stream().map(ItemMapper::toItemDto).collect(Collectors.toList());
    }


}
