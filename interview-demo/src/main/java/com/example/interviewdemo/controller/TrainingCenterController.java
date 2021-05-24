package com.example.interviewdemo.controller;

import com.example.interviewdemo.model.TrainingCenter;
import com.example.interviewdemo.model.exceptions.ValueNotValidException;
import com.example.interviewdemo.service.TrainingCenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;

@Controller
public class TrainingCenterController {

    private Logger LOGGER = LoggerFactory.getLogger(TrainingCenterController.class);

    @Autowired
    private TrainingCenterService trainingCenterService;

    @PostMapping("/add")
    @ResponseBody
    public TrainingCenter add(@Valid @RequestBody TrainingCenter trainingCenter) {
        return trainingCenterService.add(trainingCenter);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<TrainingCenter> getAllCenters() {
        return trainingCenterService.getAll();
    }

    @ExceptionHandler(ValueNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleError(ValueNotValidException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }
}
