package com.agu.coffeeshop.controllers;

import com.agu.coffeeshop.controllers.dto.ItemResponseDto;
import com.agu.coffeeshop.controllers.dto.ItemUpsertDto;
import com.agu.coffeeshop.entities.Item;
import com.agu.coffeeshop.entities.enums.ItemType;
import com.agu.coffeeshop.exceptions.BadRequestException;
import com.agu.coffeeshop.services.BaseService;
import com.agu.coffeeshop.services.ItemService;
import com.agu.coffeeshop.validation.ItemControllerValidator;
import org.modelmapper.ModelMapper;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.agu.coffeeshop.exceptions.ApiErrorCode.EMPTY_ITEM_TYPE;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    private final ModelMapper modelMapper;
    private final BaseService<Item> baseService;
    private final ItemService itemService;
    private final ItemControllerValidator itemControllerValidator;

    public ItemController(ModelMapper modelMapper,
                          BaseService<Item> baseService,
                          ItemService itemService,
                          ItemControllerValidator itemControllerValidator) {
        this.modelMapper = modelMapper;
        this.baseService = baseService;
        this.itemService = itemService;
        this.itemControllerValidator = itemControllerValidator;
    }

    @PostMapping
    public ItemResponseDto save(@RequestBody ItemUpsertDto createDto) {
        itemControllerValidator.validateCreateItem(createDto);
        Item newItem = modelMapper.map(createDto, Item.class);
        Item savedItem = itemService.save(newItem);
        return modelMapper.map(savedItem, ItemResponseDto.class);
    }

    @GetMapping("/{id}")
    public ItemResponseDto get(@PathVariable String id) {

        return modelMapper.map(baseService.findById(id), ItemResponseDto.class);
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
        return baseService.findAll().stream()
                .map(it -> modelMapper.map(it, ItemResponseDto.class))
                .collect(Collectors.toList());
    }

    @PutMapping
    public ItemResponseDto update(@RequestBody ItemUpsertDto updateDto) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        Item item = baseService.findById(id);
        baseService.delete(item);
    }
}
