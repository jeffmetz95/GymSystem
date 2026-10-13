package com.example.asdfinalproject.controller;

import com.example.asdfinalproject.dto.ExerciseRequestDto;
import com.example.asdfinalproject.dto.ExerciseResponseDto;
import com.example.asdfinalproject.service.ExerciseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/exercises")
public class ExerciseController {
    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping
    public ExerciseResponseDto create(@RequestBody ExerciseRequestDto request){
        return exerciseService.create(request);
    }

    @GetMapping
    public List<ExerciseResponseDto> getAll(){
        return exerciseService.getAll();
    }

    @GetMapping("/{id}")
    public ExerciseResponseDto getById(@PathVariable long id){
        return exerciseService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        exerciseService.delete(id);
    }
}
