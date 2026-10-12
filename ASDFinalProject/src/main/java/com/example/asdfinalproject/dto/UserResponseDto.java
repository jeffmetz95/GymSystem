package com.example.asdfinalproject.dto;

import java.util.List;

public record UserResponseDto(
        long id,
        String name,
        double height,
        double weight,
        List<GoalRequestDto> goals,
        List<RecordRequestDto> records,
        List<SessionRequestDto> sessions,
        PlanRequestDto plan
) {
}
