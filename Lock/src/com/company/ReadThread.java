package com.company;

import java.util.concurrent.locks.Lock;

public class ReadThread extends Thread {

    private final Treasure treasure;
    Lock lock;

    public ReadThread(Treasure treasure,Lock lock) {
        this.treasure = treasure;
        this.lock = lock;
    }

    @Override
    public void run() {

        for(int i=0;i<10;i++){
            lock.lock();
            try{
                treasure.readVolatile();
            }
            finally {
                lock.unlock();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }


}