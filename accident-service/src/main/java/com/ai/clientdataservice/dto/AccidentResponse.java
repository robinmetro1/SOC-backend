package com.ai.clientdataservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccidentResponse {
    private String id;

    private String date;

    private String address;

    private String description;

    private List<String> involvedVehicles;

    private int deaths;

    private int injured;
}
