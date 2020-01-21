package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Valuable valuable = new Valuable();

        List<Thread> threadList = new ArrayList<>();
        threadList.add(new WriteThread(valuable));
        for (int i = 0; i < 3; i++) {
            threadList.add(new ReadThread(valuable));
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
