package com.agu.coffeeshop.controllers;

import com.agu.coffeeshop.controllers.dto.ItemCreateDto;
import com.agu.coffeeshop.controllers.dto.ItemResponseDto;
import com.agu.coffeeshop.controllers.dto.ItemUpdateDto;
import com.agu.coffeeshop.entities.Item;
import com.agu.coffeeshop.entities.enums.ItemType;
import com.agu.coffeeshop.exceptions.BadRequestException;
import com.agu.coffeeshop.services.ItemService;
import com.agu.coffeeshop.validation.ItemControllerValidator;
import org.modelmapper.ModelMapper;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import static com.agu.coffeeshop.exceptions.ApiErrorCode.EMPTY_ITEM_TYPE;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    private final ModelMapper modelMapper;
    private final ItemService itemService;
    private final ItemControllerValidator itemControllerValidator;

    public ItemController(ModelMapper modelMapper,
                          ItemService itemService,
                          ItemControllerValidator itemControllerValidator) {
        this.modelMapper = modelMapper;
        this.itemService = itemService;
        this.itemControllerValidator = itemControllerValidator;
    }

    @PostMapping
    public ItemResponseDto save(@RequestBody ItemCreateDto createDto) {
        itemControllerValidator.validateCreateItem(createDto);
        Item newItem = modelMapper.map(createDto, Item.class);
        newItem.setCreatedDate(Instant.now());
        Item savedItem = itemService.save(newItem);
        return modelMapper.map(savedItem, ItemResponseDto.class);
    }

    @GetMapping("/{id}")
    public ItemResponseDto get(@PathVariable String id) {
        return modelMapper.map(itemService.findById(id), ItemResponseDto.class);
    }

    @GetMapping("/item-type/{type}")
    public List<ItemResponseDto> findByItemType(@PathVariable String type) {

        if (!StringUtils.hasText(type)) {
            throw new BadRequestException(EMPTY_ITEM_TYPE.getDefaultMessage(), EMPTY_ITEM_TYPE);
        }
        return itemService.findByItemType(ItemType.valueOf(type)).stream()
                .map(it -> modelMapper.map(it, ItemResponseDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/all")
    public List<ItemResponseDto> findAll() {
        return itemService.findAll().stream()
                .map(it -> modelMapper.map(it, ItemResponseDto.class))
                .collect(Collectors.toList());
    }

    @PutMapping
    public ItemResponseDto update(@RequestBody ItemUpdateDto updateDto) {
        Item updateItem = modelMapper.map(updateDto, Item.class);
        Item updatedItem = itemService.update(updateItem);
        return modelMapper.map(updatedItem, ItemResponseDto.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        Item item = itemService.findById(id);
        itemService.delete(item);
    }
}
