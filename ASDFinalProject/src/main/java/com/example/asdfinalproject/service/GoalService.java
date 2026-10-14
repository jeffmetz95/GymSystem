package com.example.asdfinalproject.service;

import com.example.asdfinalproject.dto.GoalRequestDto;
import com.example.asdfinalproject.dto.GoalResponseDto;
import com.example.asdfinalproject.entities.Goal;
import com.example.asdfinalproject.repositories.GoalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoalService {
    private final GoalRepository goalRepository;
    private final ModelMapper modelMapper;

    public GoalService(GoalRepository goalRepository, ModelMapper modelMapper) {
        this.goalRepository = goalRepository;
        this.modelMapper = modelMapper;
    }

    public GoalResponseDto create(GoalRequestDto request){
        Goal goal = modelMapper.map(request, Goal.class);
        GoalResponseDto response = modelMapper.map(goalRepository.save(goal), GoalResponseDto.class);
        return response;
    }

    public List<GoalResponseDto> getAll(){
        List<Goal> goals = goalRepository.findAll();
        List<GoalResponseDto> response = new ArrayList<>();
        for (Goal g: goals){
            response.add(modelMapper.map(g, GoalResponseDto.class));
        }
        return response;
    }

    public GoalResponseDto getById(long id){
        Goal goal = goalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Goal not found."));
        return modelMapper.map(goal,GoalResponseDto.class);
    }

    public void delete(long id){
        goalRepository.deleteById(id);
    }
}
