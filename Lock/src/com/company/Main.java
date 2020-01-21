package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Valuable valuable = new Valuable();
        List <Thread> threadList = new ArrayList<>();
        threadList.add(new WriteThread(valuable,lock));
        for (int i = 0; i < 3; i++) {
            threadList.add(new ReadThread(valuable,lock));
        };
        threadList.forEach(Thread::start);

        try {
            for (Thread thread : threadList) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("This is the end");

    }
}
