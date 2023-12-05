package com.ai.clientdataservice.repository;

import com.ai.clientdataservice.model.RoadAccident;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoadAccidentRepository extends MongoRepository<RoadAccident,String> {



}
