package com.ai.clientdataservice.controller;


import com.ai.clientdataservice.dto.AccidentRequest;
import com.ai.clientdataservice.dto.AccidentResponse;
import com.ai.clientdataservice.model.RoadAccident;
import com.ai.clientdataservice.service.RoadAccidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accident")
public class RoadAccidentController {
    private final RoadAccidentService roadAccidentService;

    public RoadAccidentController(RoadAccidentService roadAccidentService) {
        this.roadAccidentService = roadAccidentService;
    }


    @PostMapping
    public ResponseEntity addAccident(@RequestBody AccidentRequest accidentRequest)
    {
        roadAccidentService.addAccident(accidentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AccidentResponse> getAllAccidents()
    {
        return roadAccidentService.getAllAccidents();

    }
}
