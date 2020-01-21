package com.company;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadThread extends Thread {

    private final Valuable valuable;
    final private ReentrantReadWriteLock.ReadLock readLock;

    public ReadThread(Valuable valuable, ReentrantReadWriteLock.ReadLock lock) {
        this.valuable = valuable;
        this.readLock = lock;
    }

    @Override
    public void run() {

        for(int i=0;i<10;i++){

            readLock.lock();
            try {
                valuable.readVolatile();
            }
            finally{
                readLock.unlock();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}