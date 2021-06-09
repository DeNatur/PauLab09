package com.sstasik.paulab09.enitities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.text.SimpleDateFormat;
@Entity
public class TrainStation{
    private String stationName;
    private int maxCapacity;
    private long timeArrive;
    public String name;
    public String time;
    @Id
    @GeneratedValue
    private long id;

    public TrainStation(String stationName, int maxCapacity){
        this.stationName = stationName;
        this.maxCapacity = maxCapacity;
        this.name = stationName;
        this.time ="" ;
    }

    public TrainStation() { }

    public static TrainStation copy(TrainStation trainStation){
        return new TrainStation(trainStation.getName(), trainStation.getMaxCapacity());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getTimeArrive() {
        return timeArrive;
    }

    public void setTimeArrive(long timeArrive) {
        this.timeArrive = timeArrive;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        time = simpleDateFormat.format(timeArrive);
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public long getId() {
        return id;
    }
}
