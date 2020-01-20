package com.company;

public class ReadThread extends Thread {

    private final Treasure treasure;

    public ReadThread(Treasure treasure) {
        this.treasure = treasure;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            treasure.readVolatile();

        }


    }


}