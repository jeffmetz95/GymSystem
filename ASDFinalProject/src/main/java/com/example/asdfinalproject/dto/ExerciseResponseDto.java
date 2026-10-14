package com.example.asdfinalproject.dto;

import java.util.List;

public record ExerciseResponseDto(
        long id,
        String name,
        String description,
        int weight,
        int sets,
        int reps//,
//        List<PlanResponseDto> plans,
//        List<GoalResponseDto> goals,
//        List<RecordResponseDto> records,
//        List<SessionResponseDto> sessions
) {
}
