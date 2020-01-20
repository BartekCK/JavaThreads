package com.company;

public class Treasure {

    private volatile int value =0;

    public  void writeVolatile() {
        int tmp = value;
        tmp++;
        value = tmp;
    }
    public void readVolatile() {
        int tmp = value;
        System.out.println("Read value: "+  tmp);
    }

}