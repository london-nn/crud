package com.example.demo.controller;

import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Item;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/items")
public class ItemController {
    private final LocalContainerEntityManagerFactoryBean entityManagerFactory;
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto) {
        ItemDto savedItem = itemService.createItem(itemDto);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable("id") Long id) {
        ItemDto savedItem = itemService.getItemById(id);
        return ResponseEntity.ok(savedItem);
    }

    @GetMapping
    public ResponseEntity<List<ItemDto>> getAllItems() {
        List<ItemDto> savedItems = itemService.getAllItems();
        return ResponseEntity.ok(savedItems);
    }

    @PutMapping("{id}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable("id") Long id, @RequestBody ItemDto updatedItem) {
        ItemDto itemDto = itemService.updatedItem(id, updatedItem);
        return ResponseEntity.ok(itemDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteItem(@PathVariable("id") Long id) {
        itemService.deleteItem(id);
    return ResponseEntity.ok("Item deleted");
    }

}
