package com.company;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    public static void main(String[] args) {
        Treasure treasure = new Treasure();
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        WriteThread writeThread = new WriteThread(treasure,lock.writeLock());
        ReadThread readThread1 = new ReadThread(treasure,lock.readLock());
        ReadThread readThread2 = new ReadThread(treasure,lock.readLock());
        ReadThread readThread3 = new ReadThread(treasure,lock.readLock());

        writeThread.start();
        readThread1.start();
        readThread2.start();
        readThread3.start();

        try {
            writeThread.join();
            readThread1.join();
            readThread2.join();
            readThread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
