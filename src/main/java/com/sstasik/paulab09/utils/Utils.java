package com.sstasik.paulab09.utils;

import com.sstasik.paulab09.enitities.Rating;

import java.util.List;
public class Utils {

    public static float calculateAverageRatingForTrain(List<Rating> ratingList){
        int rating = 0;
        for(Rating ratings : ratingList){
            rating += ratings.getScore();
        }
        return rating / ratingList.size();
    }
}
