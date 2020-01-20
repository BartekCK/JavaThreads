package com.company;

import java.util.concurrent.locks.Lock;

public class WriteThread extends Thread {

    private final Treasure treasure;
    Lock lock;


    public WriteThread(Treasure treasure, Lock lock)
    {
        this.treasure = treasure;
        this.lock = lock;
    }

    @Override
    public void run() {

        for(int i=0;i<10;i++) {

            lock.lock();
            try
            {
                treasure.writeVolatile();

            }
            finally {
                lock.unlock();
            }

            try {
                Thread.sleep(950);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}