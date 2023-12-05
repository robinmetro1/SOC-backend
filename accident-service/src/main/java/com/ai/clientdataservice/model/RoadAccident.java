package com.ai.clientdataservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Document("RoadAccident")
public class RoadAccident {
    @Id
    private String id;

    @Field("date")
    private String date;

    @Field("address")
    private String address;

    @Field("description")
    private String description;

    @Field("involvedVehicles")
    private List<String> involvedVehicles;

    @Field("deaths")
    private int deaths;

    @Field("injured")
    private int injured;



}
