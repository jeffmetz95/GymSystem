package com.example.asdfinalproject.service;

import com.example.asdfinalproject.config.ModelMapperConfig;
import com.example.asdfinalproject.dto.ExerciseRequestDto;
import com.example.asdfinalproject.dto.ExerciseResponseDto;
import com.example.asdfinalproject.entities.Exercise;
import com.example.asdfinalproject.repositories.ExerciseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    ModelMapper modelMapper = new ModelMapper();

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public ExerciseResponseDto create(ExerciseRequestDto request){
        Exercise exercise = modelMapper.map(request, Exercise.class);
        ExerciseResponseDto response = modelMapper.map(exercise, ExerciseResponseDto.class);
        return response;
    }
}
