package com.sstasik.paulab09.enitities;


import javax.annotation.processing.Generated;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Train implements Comparable<Train> {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int seats;
    private long timeArrive = -1;
    private long timeDeparture = -1;
    private TrainState trainState = TrainState.OK;

    public Train(String name, int seats){
        this.name = name;
        this.seats = seats;
    }

    protected Train() { }

    public long getId() {
        return id;
    }

    public static Train copy(Train train){
        return new Train(train.getName(), train.getSeats());
    }

    public static Train getNewTrainWithTimes(Train train,
                                             int timeArrive,
                                             int timeDeparture){
        Train result = new Train(train.name, train.seats);
        result.setTimeArrive(timeArrive);
        result.setTimeDeparture(timeDeparture);
        return result;
    }

    public TrainState getTrainState() { return trainState; }

    public void setTrainState(TrainState trainState) { this.trainState = trainState; }

    public long travelTime(){
        return timeArrive - timeDeparture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public long getTimeArrive() {
        return timeArrive;
    }

    public void setTimeArrive(long timeArrive) {
        this.timeArrive = timeArrive;
    }

    public void setTimeArriveDeparture(long timeArrive, long timeDeparture){
        this.timeArrive = timeArrive;
        this.timeDeparture = timeDeparture;
    }
    public long getTimeDeparture() {
        return timeDeparture;
    }

    public void setTimeDeparture(long timeDeparture) {
        this.timeDeparture = timeDeparture;
    }

    @Override
    public String toString() {
        return "Train{" +
                "name='" + name + '\'' +
                ", seats=" + seats +
                '}';
    }

    @Override
    public int compareTo(Train o) {
        return o.name.compareTo(this.name);
    }
}