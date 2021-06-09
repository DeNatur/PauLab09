package com.sstasik.paulab09;

import com.sstasik.paulab09.enitities.Train;
import com.sstasik.paulab09.enitities.TrainStation;
import com.sstasik.paulab09.enitities.TrainStationContainer;
import com.sstasik.paulab09.services.TrainDAOService;
import com.sstasik.paulab09.services.TrainRepository;
import com.sstasik.paulab09.services.TrainStationContainerRepository;
import com.sstasik.paulab09.services.TrainStationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TrainDaoServiceCommandLineRunner implements CommandLineRunner {
    private static  final Logger log = LoggerFactory.getLogger(TrainDaoServiceCommandLineRunner.class);

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private TrainStationContainerRepository trainStationContainerRepository;

    @Autowired
    private TrainStationRepository trainStationRepository;

    @Override
    public void run(String... args) throws Exception {
        Train train = new Train("Chopin", 10);
        Train train2 = new Train("TLK", 6);
        Train train3 = new Train("Pendolino", 3);

        addTrains(train, train2, train3);

        TrainStation trainStationKRK = new TrainStation("Kraków Główny", 10);
        TrainStation trainStationMiechow = new TrainStation("Miechów", 10);
        TrainStation trainStationWarZach = new TrainStation("Warszawa Zachodnia", 10);
        TrainStation trainStationWar = new TrainStation("Warszawa", 10);

        addTrainStations(trainStationKRK, trainStationMiechow, trainStationWarZach, trainStationWar);

        TrainStationContainer trainStationContainer = new TrainStationContainer(train);
        trainStationContainerRepository.save(trainStationContainer);
        log.info("new TrainStation is created: " + train);
    }

    private void addTrainStations(TrainStation trainStationKRK, TrainStation trainStationMiechow, TrainStation trainStationWarZach, TrainStation trainStationWar) {
        trainStationRepository.save(trainStationKRK);
        trainStationRepository.save(trainStationMiechow);
        trainStationRepository.save(trainStationWarZach);
        trainStationRepository.save(trainStationWar);
        trainStationRepository.save(trainStationKRK);
    }

    private void addTrains(Train train, Train train2, Train train3) {
        trainRepository.save(train);
        log.info("new Train is created: " + train);
        trainRepository.save(train2);
        log.info("new Train is created: " + train2);
        trainRepository.save(train3);
        log.info("new Train is created: " + train3);
    }
}
