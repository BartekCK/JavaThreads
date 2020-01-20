package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WriteThread extends Thread {

    private final Treasure treasure;
    final private ReentrantReadWriteLock.WriteLock writeLock;

    public WriteThread(Treasure treasure,ReentrantReadWriteLock.WriteLock lock)
    {
        this.treasure = treasure;
        this.writeLock=lock;

    }

    @Override
    public void run() {



        for(int i=0;i<10;i++) {

            writeLock.lock();

            try {
                treasure.writeVolatile();
            }

            finally {
                writeLock.unlock();
            }

            try {
                Thread.sleep(950);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}