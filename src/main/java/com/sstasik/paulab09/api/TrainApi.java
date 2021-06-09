package com.sstasik.paulab09.api;

import com.sstasik.paulab09.enitities.Train;
import com.sstasik.paulab09.services.TrainRepository;
import com.sstasik.paulab09.utils.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

@RestController
public class TrainApi {

    @Autowired
    private TrainRepository trainRepository;

    @GetMapping("/getTrains")
    public List<Train> getTrains(){
        return trainRepository.findAll();
    }

    @GetMapping("/getTrainsInCSV")
    public String getTrainsInCSV(){
        try {
            return CSVWriter.produceCsvData(trainRepository.findAll().toArray());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return "";
    }

    @DeleteMapping("/deleteTrain/{id}")
    public void deleteTrain(@PathVariable("id") long id){
        if(trainRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Train with ID not found!");
        }
        trainRepository.deleteById(id);
    }

    @PostMapping("/addTrain")
    public void addTrain(@RequestBody Train train){
        if(train == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You must provide train object!");
        }
        if(train.getName() ==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You must provide train name!");
        }
        trainRepository.save(train);
    }

    @GetMapping("/getTrainFill/{id}")
    public int getTrainFill(@PathVariable("id") long id){
        Optional<Train> train = trainRepository.findById(id);
        if(train.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Train with ID not found!");
        }
        return train.get().getSeats();
    }

}
