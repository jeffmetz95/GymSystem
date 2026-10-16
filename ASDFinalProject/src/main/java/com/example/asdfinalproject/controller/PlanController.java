package com.example.asdfinalproject.controller;

import com.example.asdfinalproject.dto.PlanRequestDto;
import com.example.asdfinalproject.dto.PlanResponseDto;
import com.example.asdfinalproject.service.PlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/plans")
public class PlanController {
    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping
    public PlanResponseDto create(@RequestBody PlanRequestDto request){
        return planService.create(request);
    }

    @GetMapping
    public List<PlanResponseDto> getAll(){
        return planService.getAll();
    }

    @GetMapping("/{id}")
    public PlanResponseDto getById(@PathVariable long id){
        return planService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        planService.delete(id);
    }
}
