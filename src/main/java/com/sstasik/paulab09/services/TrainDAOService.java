package com.sstasik.paulab09.services;

import com.sstasik.paulab09.enitities.Train;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class TrainDAOService {

    @PersistenceContext
    private EntityManager entityManager;

    public long insert(Train train){
        //Open transaction
        entityManager.persist(train);
        //Close transaction
        return train.getId();
    }
}
