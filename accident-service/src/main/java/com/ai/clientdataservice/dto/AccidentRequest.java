package com.ai.clientdataservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccidentRequest {
    private String date;

    private String address;

    private String description;

    private List<String> involvedVehicles;

    private int deaths;

    private int injured;

}
