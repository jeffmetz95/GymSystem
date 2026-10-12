package com.example.asdfinalproject.dto;

import com.example.asdfinalproject.entities.User;

import java.util.List;

public record PlanRequestDto(
        List<ExerciseRequestDto> exercises,
        User user
) {
}
