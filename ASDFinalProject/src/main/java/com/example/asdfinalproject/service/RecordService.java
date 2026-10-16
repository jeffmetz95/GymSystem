package com.example.asdfinalproject.service;

import com.example.asdfinalproject.dto.RecordRequestDto;
import com.example.asdfinalproject.dto.RecordResponseDto;
import com.example.asdfinalproject.entities.Record;
import com.example.asdfinalproject.repositories.RecordRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordService {
    private final RecordRepository recordRepository;
    private final ModelMapper modelMapper;

    public RecordService(RecordRepository recordRepository, ModelMapper modelMapper) {
        this.recordRepository = recordRepository;
        this.modelMapper = modelMapper;
    }

    public RecordResponseDto create(RecordRequestDto request){
        com.example.asdfinalproject.entities.Record record =
                modelMapper.map(request, com.example.asdfinalproject.entities.Record.class);
        RecordResponseDto response = modelMapper.map(recordRepository.save(record), RecordResponseDto.class);
        return response;
    }

    public List<RecordResponseDto> getAll(){
        List<Record> records = recordRepository.findAll();
        List<RecordResponseDto> response = new ArrayList<>();
        for (Record r: records){
            response.add(modelMapper.map(r, RecordResponseDto.class));
        }
        return response;
    }

    public RecordResponseDto getById(long id){
        Record record = recordRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Record not found."));
        return modelMapper.map(record,RecordResponseDto.class);
    }

    public void delete(long id){
        recordRepository.deleteById(id);
    }
}
