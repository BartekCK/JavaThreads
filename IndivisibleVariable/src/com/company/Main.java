package com.company;

public class Main {

    public static void main(String[] args) {
        Treasure treasure = new Treasure();
        WriteThread writeThread = new WriteThread(treasure);
        ReadThread readThread1 = new ReadThread(treasure);
        ReadThread readThread2 = new ReadThread(treasure);
        ReadThread readThread3 = new ReadThread(treasure);

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


        System.out.println("All threads dead...");

    }
}
