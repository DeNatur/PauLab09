package com.sstasik.paulab09.api;

import com.sstasik.paulab09.enitities.Train;
import com.sstasik.paulab09.enitities.TrainStation;
import com.sstasik.paulab09.services.TrainRepository;
import com.sstasik.paulab09.services.TrainStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
public class TrainStationApi {
    @Autowired
    private TrainStationRepository trainStationRepository;

    @GetMapping("/getTrainStations")
    public List<TrainStation> getTrains(){
        return trainStationRepository.findAll();
    }

    @PostMapping("/addTrainStation")
    public void addTrain(@RequestBody TrainStation trainStation){
        if(trainStation == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You must provide train object!");
        }
        if(trainStation.getName() ==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You must provide train name!");
        }
        trainStationRepository.save(trainStation);
    }

    @DeleteMapping("/deleteTrainStation/{id}")
    public void deleteTrain(@PathVariable("id") long id){
        if(trainStationRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Train with ID not found!");
        }
        trainStationRepository.deleteById(id);
    }


}
