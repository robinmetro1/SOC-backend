package com.ai.clientdataservice.service;

import com.ai.clientdataservice.dto.AccidentRequest;
import com.ai.clientdataservice.dto.AccidentResponse;
import com.ai.clientdataservice.model.RoadAccident;
import com.ai.clientdataservice.repository.RoadAccidentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoadAccidentService {
    private final RoadAccidentRepository roadAccidentRepository;

    public void addAccident(AccidentRequest accidentRequest )
    {
        RoadAccident roadAccident = RoadAccident.builder()
                .date(accidentRequest.getDate())
                .address(accidentRequest.getAddress())
                .description(accidentRequest.getDescription())
                .injured(accidentRequest.getInjured())
                .deaths(accidentRequest.getDeaths())
                .involvedVehicles(accidentRequest.getInvolvedVehicles())
                .build();


        roadAccidentRepository.save(roadAccident);
        log.info("new accident"+roadAccident.getId() +"added");
    }

    public List<AccidentResponse> getAllAccidents()
    {
        List<RoadAccident> accidents = roadAccidentRepository.findAll();
        return  accidents.stream().map(this::mapToAccidentResponse).toList();
    }

    private AccidentResponse mapToAccidentResponse(RoadAccident accident) {
        return  AccidentResponse.builder()
                .id(accident.getId())
                .date(accident.getDate())
                .address(accident.getAddress())
                .description(accident.getDescription())
                .injured(accident.getInjured())
                .deaths(accident.getDeaths())
                .involvedVehicles(accident.getInvolvedVehicles())
                .build();
    }

}
