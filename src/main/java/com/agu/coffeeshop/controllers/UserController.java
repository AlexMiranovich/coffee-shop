package com.agu.coffeeshop.controllers;

import com.agu.coffeeshop.controllers.dto.UserResponseDto;
import com.agu.coffeeshop.controllers.dto.UserUpsertDto;
import com.agu.coffeeshop.entities.User;
import com.agu.coffeeshop.services.BaseService;
import com.agu.coffeeshop.services.UserService;
import com.agu.coffeeshop.validation.UserControllerValidator;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final ModelMapper modelMapper;
    private final BaseService<User> baseService;
    private final UserService userService;
    private final UserControllerValidator userControllerValidator;

    public UserController(ModelMapper modelMapper,
                          BaseService<User> baseService,
                          UserService userService,
                          UserControllerValidator userControllerValidator) {
        this.modelMapper = modelMapper;
        this.baseService = baseService;
        this.userService = userService;
        this.userControllerValidator = userControllerValidator;
    }

    @PostMapping
    public UserResponseDto save(@RequestBody UserUpsertDto createDto) {
        userControllerValidator.validateCreateUser(createDto);
        User newUser = modelMapper.map(createDto, User.class);
        User savedUser = userService.save(newUser);
        return modelMapper.map(savedUser, UserResponseDto.class);
    }

    @GetMapping("/{id}")
    public UserResponseDto get(@PathVariable String id) {
        return modelMapper.map(baseService.findById(id), UserResponseDto.class);
    }

    @GetMapping("/all")
    public List<UserResponseDto> findAll() {
        return baseService.findAll().stream()
                .map(it -> modelMapper.map(it, UserResponseDto.class))
                .collect(Collectors.toList());
    }

    @PutMapping
    public UserResponseDto update(@RequestBody UserUpsertDto updateDto) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        User user = baseService.findById(id);
        baseService.delete(user);
    }

}
