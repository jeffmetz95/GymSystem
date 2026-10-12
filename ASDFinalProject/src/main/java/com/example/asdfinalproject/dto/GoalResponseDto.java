package com.example.asdfinalproject.dto;

import com.example.asdfinalproject.entities.Exercise;
import com.example.asdfinalproject.entities.User;

public record GoalResponseDto(
        long id,
        User user,
        Exercise exercise
) {
}
