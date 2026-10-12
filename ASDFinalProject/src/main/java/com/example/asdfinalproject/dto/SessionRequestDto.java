package com.example.asdfinalproject.dto;

import com.example.asdfinalproject.entities.User;

import java.time.LocalDate;
import java.util.List;

public record SessionRequestDto(
        LocalDate date,
        User user,
        List<ExerciseRequestDto> exercises
) {
}
