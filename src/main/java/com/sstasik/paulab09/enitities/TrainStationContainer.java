package com.sstasik.paulab09.enitities;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
public class TrainStationContainer{
    @ManyToOne
    private Train train;
    @Id
    @GeneratedValue
    private long id;

    @OneToMany
    private final List<TrainStation> stationsMap = new ArrayList<>();
    private String name;
    private String timeDeparture;
    private String timeArrive;

    public TrainStationContainer(Train train) {
        this.train = train;
        Calendar calendarDeparture = Calendar.getInstance();
        calendarDeparture.setTimeInMillis(train.getTimeDeparture());

        Calendar calendarArrive = Calendar.getInstance();
        calendarArrive.setTimeInMillis(train.getTimeArrive());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        name = train.getName();
        timeDeparture = simpleDateFormat.format(calendarDeparture.getTime());
        timeArrive = simpleDateFormat.format(calendarArrive.getTime());
    }

    public TrainStationContainer() {

    }

    public long getId() {
        return id;
    }

    public List<TrainStation> getTrainStations(){
        return null;
    }

    public Train getTrain() {
        return train;
    }

    public String getName() {
        return name;
    }

//    public boolean buyTicket(){
//        if(train.getSeats() -1 > 0){
//            train.setSeats(train.getSeats() -1 );
//            return true;
//        }
//        return false;
//    }
//
//    public void cancelTicket(){
//        train.setSeats(train.getSeats() +1);
//    }


    public void setName(String name) {
        this.name = name;
    }

    public String getTimeDeparture() {
        return timeDeparture;
    }

    public void setTimeDeparture(String timeDeparture) {
        this.timeDeparture = timeDeparture;
    }

    public String getTimeArrive() {
        return timeArrive;
    }


    public void setTimeArrive(String timeArrive) {
        this.timeArrive = timeArrive;
    }

    public void add(TrainStation ts) {
        stationsMap.add(ts);
    }

    public void remove(String name){
        stationsMap.remove(name);
    }

//    public boolean goesThroughStationsBeforeTime(String s1, String s2, long time){
//        if(!goesThroughStationBeforeTime(s1, time)|| !goesThroughStationBeforeTime(s2, time))
//            return false;
//        int indexTS1 = stationsMap.keySet().stream().toList().indexOf(s1);
//        int indexTS2 = stationsMap.keySet().stream().toList().indexOf(s2);
//        System.out.println("index1: " +indexTS1 + " index2" + indexTS2);
//        return  indexTS2 > indexTS1;
//    }


    public boolean goesThroughStation(String stationName){
        return  false;
    }

//    public boolean goesThroughStationBeforeTime(String stationName, long time){
//        return stationsMap.containsKey(stationName) && train.getTimeArrive() > time;
//    }


}
