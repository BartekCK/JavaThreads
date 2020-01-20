package com.company;

import java.util.concurrent.atomic.AtomicInteger;

public class Treasure {

    public static AtomicInteger value = new AtomicInteger(0);
    Integer number= 0;
    public  void writeVolatile() {

        number++;
        Treasure.value.set(number);
    }
    public void readVolatile() {
        System.out.println("Read value: " + value);
    }

}