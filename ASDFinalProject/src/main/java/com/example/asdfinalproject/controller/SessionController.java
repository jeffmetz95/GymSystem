package com.example.asdfinalproject.controller;

import com.example.asdfinalproject.dto.SessionRequestDto;
import com.example.asdfinalproject.dto.SessionResponseDto;
import com.example.asdfinalproject.service.SessionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sessions")
public class SessionController {
    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping
    public SessionResponseDto create(@RequestBody SessionRequestDto request){
        return sessionService.create(request);
    }

    @GetMapping
    public List<SessionResponseDto> getAll(){
        return sessionService.getAll();
    }

    @GetMapping("/{id}")
    public SessionResponseDto getById(@PathVariable long id){
        return sessionService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        sessionService.delete(id);
    }
}
