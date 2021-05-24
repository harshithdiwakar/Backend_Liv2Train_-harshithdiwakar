package com.example.interviewdemo.repository;

import com.example.interviewdemo.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Integer> {

    public List<TrainingCenter> findAll();

}
