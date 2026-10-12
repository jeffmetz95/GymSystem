package com.example.asdfinalproject.dto;

import com.example.asdfinalproject.entities.Exercise;
import com.example.asdfinalproject.entities.Session;
import com.example.asdfinalproject.entities.User;

public record RecordRequestDto(
        User user,
        Exercise exercise,
        Session session
) {
}
