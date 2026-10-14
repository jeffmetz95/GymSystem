package com.example.asdfinalproject.service;

import com.example.asdfinalproject.dto.PlanRequestDto;
import com.example.asdfinalproject.dto.PlanResponseDto;
import com.example.asdfinalproject.entities.Plan;
import com.example.asdfinalproject.repositories.PlanRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanService {
    private final PlanRepository planRepository;
    private final ModelMapper modelMapper;

    public PlanService(PlanRepository planRepository, ModelMapper modelMapper) {
        this.planRepository = planRepository;
        this.modelMapper = modelMapper;
    }

    public PlanResponseDto create(PlanRequestDto request){
        Plan plan = modelMapper.map(request, Plan.class);
        planRepository.save(plan);
        PlanResponseDto response = modelMapper.map(plan, PlanResponseDto.class);
        return response;
    }

    public List<PlanResponseDto> getAll(){
        List<Plan> plans = planRepository.findAll();
        List<PlanResponseDto> response = new ArrayList<>();
        for (Plan p: plans){
            response.add(modelMapper.map(p, PlanResponseDto.class));
        }
        return response;
    }

    public PlanResponseDto getById(long id){
        return modelMapper.map(planRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plan not found")), PlanResponseDto.class);
    }

    public void delete(long id){
        planRepository.deleteById(id);
    }
}
