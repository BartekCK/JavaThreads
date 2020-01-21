package com.company;

import java.util.concurrent.locks.Lock;

public class WriteThread extends Thread {

    private final Valuable valuable;
    Lock lock;


    public WriteThread(Valuable valuable, Lock lock)
    {
        this.valuable = valuable;
        this.lock = lock;
    }

    @Override
    public void run() {

        for(int i=0;i<10;i++) {

            lock.lock();
            try
            {
                valuable.writeVolatile();

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