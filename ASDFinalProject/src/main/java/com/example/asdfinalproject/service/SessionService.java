package com.example.asdfinalproject.service;

import com.example.asdfinalproject.dto.GoalResponseDto;
import com.example.asdfinalproject.dto.SessionRequestDto;
import com.example.asdfinalproject.dto.SessionResponseDto;
import com.example.asdfinalproject.entities.Session;
import com.example.asdfinalproject.repositories.SessionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;
    private final ModelMapper modelMapper;

    public SessionService(SessionRepository sessionRepository, ModelMapper modelMapper) {
        this.sessionRepository = sessionRepository;
        this.modelMapper = modelMapper;
    }

    public SessionResponseDto create(SessionRequestDto request){
        Session session = modelMapper.map(request, Session.class);
        SessionResponseDto response = modelMapper.map(sessionRepository.save(session), SessionResponseDto.class);
        return response;
    }

    public List<SessionResponseDto> getAll(){
        List<Session> sessions = sessionRepository.findAll();
        List<SessionResponseDto> response = new ArrayList<>();
        for (Session s: sessions){
            response.add(modelMapper.map(s, SessionResponseDto.class));
        }
        return response;
    }

    public SessionResponseDto getById(long id){
        Session session = sessionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Session not found"));
        return modelMapper.map(session, SessionResponseDto.class);
    }

    public void delete(long id){
        sessionRepository.deleteById(id);
    }
}
