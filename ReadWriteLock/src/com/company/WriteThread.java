package com.company;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WriteThread extends Thread {

    private final Valuable valuable;
    final private ReentrantReadWriteLock.WriteLock writeLock;

    public WriteThread(Valuable valuable, ReentrantReadWriteLock.WriteLock lock)
    {
        this.valuable = valuable;
        this.writeLock=lock;

    }

    @Override
    public void run() {



        for(int i=0;i<10;i++) {

            writeLock.lock();

            try {
                valuable.writeVolatile();
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