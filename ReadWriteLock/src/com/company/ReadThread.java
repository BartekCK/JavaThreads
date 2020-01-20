package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadThread extends Thread {

    private final Treasure treasure;
    final private ReentrantReadWriteLock.ReadLock readLock;

    public ReadThread(Treasure treasure,ReentrantReadWriteLock.ReadLock lock) {
        this.treasure = treasure;
        this.readLock = lock;
    }

    @Override
    public void run() {

        for(int i=0;i<10;i++){

            readLock.lock();
            try {
                treasure.readVolatile();
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