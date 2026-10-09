package com.example.asdfinalproject.repositories;

import com.example.asdfinalproject.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
}
