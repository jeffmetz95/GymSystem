package com.example.asdfinalproject.dto;

import com.example.asdfinalproject.entities.Exercise;
import com.example.asdfinalproject.entities.User;

public record GoalRequestDto(
        User user,
        Exercise exercise
) {
}
