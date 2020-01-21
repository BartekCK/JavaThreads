package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    public static void main(String[] args) {
        Valuable valuable = new Valuable();
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();


        List<Thread> threadList = new ArrayList<>();
        threadList.add(new WriteThread(valuable,lock.writeLock()));
        for (int i = 0; i < 3; i++) {
            threadList.add(new ReadThread(valuable,lock.readLock()));
        };
        threadList.forEach(Thread::start);

        try {
            for (Thread thread : threadList) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
