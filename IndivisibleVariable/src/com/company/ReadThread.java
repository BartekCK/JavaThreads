package com.company;

public class ReadThread extends Thread {

    private final Valuable valuable;

    public ReadThread(Valuable valuable) {
        this.valuable = valuable;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            valuable.readVolatile();

        }


    }


}