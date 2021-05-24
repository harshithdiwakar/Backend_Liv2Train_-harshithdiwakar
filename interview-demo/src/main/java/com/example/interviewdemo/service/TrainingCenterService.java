package com.example.interviewdemo.service;

import com.example.interviewdemo.model.TrainingCenter;
import com.example.interviewdemo.model.exceptions.ValueNotValidException;
import com.example.interviewdemo.repository.TrainingCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TrainingCenterService {

    @Autowired
    private TrainingCenterRepository repository;

    public TrainingCenter add(TrainingCenter center) throws ValueNotValidException {
        center.setCreatedOn(System.currentTimeMillis());
        return repository.save(center);
    }

    public List<TrainingCenter> getAll() {
        return repository.findAll();
    }
}
