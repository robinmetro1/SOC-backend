package com.ai.clientdataservice.controller;


import com.ai.clientdataservice.dto.AccidentRequest;
import com.ai.clientdataservice.dto.AccidentResponse;
import com.ai.clientdataservice.model.RoadAccident;
import com.ai.clientdataservice.service.RoadAccidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

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


    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public  AccidentResponse getRoadAccidentById(@PathVariable("id") String id)
    {
        try{
            return  roadAccidentService.getRoadAccidentById(id);
        }
        catch (NoSuchElementException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Accident with ID %s not found.".formatted(id));
        }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccident(@PathVariable("id") String id){
        try{
            roadAccidentService.deleteAccident(id);
        }
        catch (NoSuchElementException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Accident with ID %s not found.".formatted(id));
        }
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateAccident(@PathVariable("id") String id, @RequestBody AccidentRequest accidentRequest) {
        try{
            roadAccidentService.updateAccident(accidentRequest, id);
        }
        catch (NoSuchElementException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Accident with ID %s not found.".formatted(id));
        }
    }


}
