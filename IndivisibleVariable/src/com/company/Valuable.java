package com.company;

import java.util.concurrent.atomic.AtomicInteger;

public class Valuable {

    public static AtomicInteger value = new AtomicInteger(0);
    Integer number= 0;
    public  void writeVolatile() {

        number++;
        Valuable.value.set(number);
    }
    public void readVolatile() {
        System.out.println("Read value: " + value);
    }

}