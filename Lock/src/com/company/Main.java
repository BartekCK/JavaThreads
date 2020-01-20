package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Treasure treasure = new Treasure();
        WriteThread writeThread = new WriteThread(treasure,lock);
        ReadThread readThread1 = new ReadThread(treasure,lock);
        ReadThread readThread2 = new ReadThread(treasure,lock);
        ReadThread readThread3 = new ReadThread(treasure,lock);

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
