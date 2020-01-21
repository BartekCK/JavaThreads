package com.company;

public class WriteThread extends Thread {

    private final Valuable valuable;

    public WriteThread(Valuable valuable) {
        this.valuable = valuable;
    }

    @Override
    public void run() {

        for(int i=0;i<10;i++) {
            valuable.writeVolatile();

        }

    }

}