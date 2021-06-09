package com.sstasik.paulab09.enitities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Rating {
    @Id
    @GeneratedValue
    long id;

    private long trainId;
    private long date;
    private String desc;
    private int score;

    protected Rating(){
    }

}
