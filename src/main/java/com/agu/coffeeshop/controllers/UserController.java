package com.agu.coffeeshop.controllers;

import com.agu.coffeeshop.controllers.dto.UserCreateDto;
import com.agu.coffeeshop.controllers.dto.UserResponseDto;
import com.agu.coffeeshop.controllers.dto.UserUpdateDto;
import com.agu.coffeeshop.entities.User;
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
    private final UserService userService;
    private final UserControllerValidator userControllerValidator;

    public UserController(ModelMapper modelMapper,
                          UserService userService,
                          UserControllerValidator userControllerValidator) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.userControllerValidator = userControllerValidator;
    }

    @PostMapping
    public UserResponseDto save(@RequestBody UserCreateDto createDto) {
        userControllerValidator.validateCreateUser(createDto);
        User newUser = modelMapper.map(createDto, User.class);
        User savedUser = userService.save(newUser);
        return modelMapper.map(savedUser, UserResponseDto.class);
    }

    @GetMapping("/{id}")
    public UserResponseDto get(@PathVariable String id) {
        return modelMapper.map(userService.findById(id), UserResponseDto.class);
    }

    @GetMapping("/all")
    public List<UserResponseDto> findAll() {
        return userService.findAll().stream()
                .map(it -> modelMapper.map(it, UserResponseDto.class))
                .collect(Collectors.toList());
    }

    @PutMapping
    public UserResponseDto update(@RequestBody UserUpdateDto updateDto) {
        User updateUser = modelMapper.map(updateDto, User.class);
        User updatedUser = userService.update(updateUser);
        return modelMapper.map(updatedUser, UserResponseDto.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        User user = userService.findById(id);
        userService.delete(user);
    }

}
