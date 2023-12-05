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
        log.info("new accident @ID "+roadAccident.getId() +"added");
    }

    public List<AccidentResponse> getAllAccidents()
    {
        List<RoadAccident> accidents = roadAccidentRepository.findAll();
        return  accidents.stream().map(this::mapToAccidentResponse).toList();
    }




    public AccidentResponse getRoadAccidentById(String id) {
       return roadAccidentRepository.findById(id).map(this::mapToAccidentResponse).orElseThrow();
    }

    public void deleteAccident(String id) {
        RoadAccident accidentToDelete = roadAccidentRepository.findById(id).orElseThrow();
        roadAccidentRepository.delete(accidentToDelete);
    }

    public void updateAccident(AccidentRequest accidentRequest, String id) {
        RoadAccident accidentToUpdate = roadAccidentRepository.findById(id).orElseThrow();
        if (accidentRequest.getDescription() != null) {
            accidentToUpdate.setDescription(accidentRequest.getDescription());
        }

        if (accidentRequest.getDate() != null) {
            accidentToUpdate.setDate(accidentRequest.getDate());
        }

        if (accidentRequest.getAddress() != null) {
            accidentToUpdate.setAddress(accidentRequest.getAddress());
        }

        if (accidentRequest.getInjured() != 0) {
            accidentToUpdate.setInjured(accidentRequest.getInjured());
        }

        if (accidentRequest.getDeaths() != 0) {
            accidentToUpdate.setDeaths(accidentRequest.getDeaths());
        }

        if (accidentRequest.getInvolvedVehicles() != null) {
            accidentToUpdate.setInvolvedVehicles(accidentRequest.getInvolvedVehicles());
        }


        roadAccidentRepository.save(accidentToUpdate);

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
