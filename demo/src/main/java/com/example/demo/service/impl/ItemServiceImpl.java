package com.example.demo.service.impl;

import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Item;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.ItemMapper;
import com.example.demo.repository.ItemRepository;
import com.example.demo.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    @Override
    public ItemDto createItem(ItemDto itemDto) {
        Item item = ItemMapper.mapToItem(itemDto);
        Item savedItem = itemRepository.save(item);
        return ItemMapper.mapToItemDto(savedItem);
    }

    @Override
    public ItemDto getItemById(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Item not found with given ID: " +  id));

        return ItemMapper.mapToItemDto(item);
    }

    @Override
    public List<ItemDto> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return items.stream().map((item) -> ItemMapper.mapToItemDto(item))
                .collect(Collectors.toList());
    }

    @Override
    public ItemDto updatedItem(Long id, ItemDto updatedItem) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Item not found with given ID: " +  id));
        item.setName(updatedItem.getName());
        item.setDescription(updatedItem.getDescription());
        item.setPrice(updatedItem.getPrice());

        Item updatedItemObj = itemRepository.save(item);
        return ItemMapper.mapToItemDto(updatedItemObj);
    }

    @Override
    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Item not found with given ID: " +  id));
        itemRepository.deleteById(id);
    }

}
