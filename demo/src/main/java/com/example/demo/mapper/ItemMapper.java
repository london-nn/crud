package com.example.demo.mapper;

import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Item;

public class ItemMapper {
    public static ItemDto mapToItemDto(Item item) {
        return new ItemDto(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getPrice(),
                item.getCreated_at()
        );
    }

    public static Item mapToItem(ItemDto itemDto) {
        return new Item(
                itemDto.getId(),
                itemDto.getName(),
                itemDto.getDescription(),
                itemDto.getPrice(),
                itemDto.getCreated_at()
        );
    }
}
