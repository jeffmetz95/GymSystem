package com.example.asdfinalproject.dto;

import java.util.List;

public record ExerciseRequestDto(
        String name,
        String description,
        int weight,
        int sets,
        int reps,
        List<PlanRequestDto> plans,
        List<GoalRequestDto> goals,
        List<RecordRequestDto> records,
        List<SessionRequestDto> sessions
) {
}
