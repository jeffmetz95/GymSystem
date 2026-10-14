package com.example.asdfinalproject.controller;

import com.example.asdfinalproject.dto.GoalRequestDto;
import com.example.asdfinalproject.dto.GoalResponseDto;
import com.example.asdfinalproject.service.GoalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/goals")
public class GoalContoller {
    private final GoalService goalService;

    public GoalContoller(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping
    public GoalResponseDto create(@RequestBody GoalRequestDto request){
        return goalService.create(request);
    }

    @GetMapping
    public List<GoalResponseDto> getAll(){
        return goalService.getAll();
    }

    @GetMapping("/{id}")
    public GoalResponseDto getById(@PathVariable long id){
        return goalService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        goalService.delete(id);
    }
}
