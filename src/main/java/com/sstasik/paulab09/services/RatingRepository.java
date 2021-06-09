package com.sstasik.paulab09.services;

import com.sstasik.paulab09.enitities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query(value = "SELECT * FROM rating WHERE train_Id = ?1",
            nativeQuery = true)
    Collection<Rating> findAllRatingsFromTrain(long id);
}
