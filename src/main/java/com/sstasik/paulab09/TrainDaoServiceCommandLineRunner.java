package com.sstasik.paulab09;

import com.sstasik.paulab09.enitities.Train;
import com.sstasik.paulab09.services.TrainDAOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TrainDaoServiceCommandLineRunner implements CommandLineRunner {
    private static  final Logger log = LoggerFactory.getLogger(TrainDaoServiceCommandLineRunner.class);

    @Autowired
    private TrainDAOService trainDAOService;

    @Override
    public void run(String... args) throws Exception {
        Train train = new Train("Chopin", 23);
        long insert = trainDAOService.insert(train);
        log.info("new Train is created: " + train);
    }
}
