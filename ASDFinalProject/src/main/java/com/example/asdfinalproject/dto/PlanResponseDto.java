package com.example.asdfinalproject.dto;

import com.example.asdfinalproject.entities.User;

import java.util.List;

public record PlanResponseDto(
        long id,
        List<ExerciseResponseDto> exercises,
        User user
) {
}
