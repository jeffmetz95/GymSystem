package com.example.asdfinalproject.dto;

import com.example.asdfinalproject.entities.User;

import java.time.LocalDate;
import java.util.List;

public record SessionResponseDto(
        long id,
        LocalDate date,
        User user,
        List<ExerciseResponseDto> exercises
) {
}
