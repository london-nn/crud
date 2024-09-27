package com.example.demo.service;

import com.example.demo.dto.ItemDto;

import java.util.List;

public interface ItemService {
    ItemDto createItem(ItemDto itemDto);

    ItemDto getItemById(Long id);

    List<ItemDto> getAllItems();

    ItemDto updatedItem(Long id, ItemDto updatedItem);

    void deleteItem(Long id);
}
