package com.example.asdfinalproject.controller;

import com.example.asdfinalproject.dto.UserRequestDto;
import com.example.asdfinalproject.dto.UserResponseDto;
import com.example.asdfinalproject.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDto create(@RequestBody UserRequestDto request){
        return userService.create(request);
    }

    @GetMapping
    public List<UserResponseDto> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserResponseDto getById(@PathVariable long id){
        return userService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        userService.delete(id);
    }
}
