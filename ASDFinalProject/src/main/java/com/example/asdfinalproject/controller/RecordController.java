package com.example.asdfinalproject.controller;

import com.example.asdfinalproject.dto.RecordRequestDto;
import com.example.asdfinalproject.dto.RecordResponseDto;
import com.example.asdfinalproject.service.RecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/records")
public class RecordController {
    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping
    public RecordResponseDto create(@RequestBody RecordRequestDto request){
        return recordService.create(request);
    }

    @GetMapping
    public List<RecordResponseDto> getAll(){
        return recordService.getAll();
    }

    @GetMapping("/{id}")
    public RecordResponseDto getById(@PathVariable long id){
        return recordService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        recordService.delete(id);
    }
}
