package com.example.asdfinalproject.service;

import com.example.asdfinalproject.config.ModelMapperConfig;
import com.example.asdfinalproject.dto.ExerciseRequestDto;
import com.example.asdfinalproject.dto.ExerciseResponseDto;
import com.example.asdfinalproject.entities.Exercise;
import com.example.asdfinalproject.entities.Plan;
import com.example.asdfinalproject.repositories.ExerciseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;
//    ModelMapper modelMapper = new ModelMapper();

    public ExerciseService(ExerciseRepository exerciseRepository, ModelMapper modelMapper) {
        this.exerciseRepository = exerciseRepository;
        this.modelMapper = modelMapper;
    }

    public ExerciseResponseDto create(ExerciseRequestDto request){
        Exercise exercise = modelMapper.map(request, Exercise.class);
        ExerciseResponseDto response = modelMapper
                .map(exerciseRepository.save(exercise), ExerciseResponseDto.class);
        return response;
    }

    public List<ExerciseResponseDto> getAll(){
        List<Exercise> exercises = exerciseRepository.findAll();
        List<ExerciseResponseDto> response = new ArrayList<>();
        for (Exercise e: exercises){
            response.add(modelMapper.map(e, ExerciseResponseDto.class));
        }
        return response;
    }

    public ExerciseResponseDto getById(long id){
        Exercise exercise = exerciseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Exercise not found"));
        //maybe change this to return null if no exercise is found
        return modelMapper.map(exercise, ExerciseResponseDto.class);
    }

//    public ExerciseResponseDto update(long id, ExerciseRequestDto request){
//        Exercise exercise = exerciseRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Exercise not found"));
//        exercise.setName(request.name());
//        exercise.setDescription(request.description());
//        exercise.setWeight(request.weight());
//        exercise.setSets(request.sets());
//        exercise.setReps(request.reps());
//        List<Plan> plans =
//        exercise.setPlans(modelMapper.map(request.plans(), List<Plan>.class));
//        exercise.setGoals();
//        exercise.setRecords();
//        exercise.setSessions();
//    }

    public void delete(long id){
        exerciseRepository.deleteById(id);
    }
}
