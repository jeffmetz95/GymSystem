package com.example.asdfinalproject.service;

import com.example.asdfinalproject.dto.UserRequestDto;
import com.example.asdfinalproject.dto.UserResponseDto;
import com.example.asdfinalproject.entities.User;
import com.example.asdfinalproject.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserResponseDto create(UserRequestDto request){
        User user = modelMapper.map(request,User.class);
        UserResponseDto response = modelMapper.map(userRepository.save(user), UserResponseDto.class);
        return response;
    }

    public List<UserResponseDto> getAll(){
        List<User> users = userRepository.findAll();
        List<UserResponseDto> response = new ArrayList<>();
        for (User u: users){
            response.add(modelMapper.map(u, UserResponseDto.class));
        }
        return response;
    }

    public UserResponseDto getById(long id){
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found."));
        return modelMapper.map(user, UserResponseDto.class);
    }

    public void delete(long id){
        userRepository.deleteById(id);
    }
}
