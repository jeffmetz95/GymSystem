package com.example.asdfinalproject.repositories;

import com.example.asdfinalproject.entities.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Long> {
}
