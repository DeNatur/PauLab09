package com.sstasik.paulab09.services;

import com.sstasik.paulab09.enitities.TrainStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainStationRepository  extends JpaRepository<TrainStation, Long> {
}
