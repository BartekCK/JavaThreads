package com.company;

public class WriteThread extends Thread {

    private final Treasure treasure;

    public WriteThread(Treasure treasure) {
        this.treasure = treasure;
    }

    @Override
    public void run() {

        for(int i=0;i<10;i++) {
            treasure.writeVolatile();

        }

    }

}