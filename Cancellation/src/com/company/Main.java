package com.company;

import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose type of canceling");
        System.out.println("1) Argument");
        System.out.println("2) Interruption");
        System.out.println("3) Future");
        System.out.println("4) Poison pill");
        int choose = scanner.nextInt();

        Machine machine = new Machine(choose);
        machine.start();

        switch (choose){

            case 1: {
                Main.sleepMe(3000);
                machine.setCanceled(true);
            }
            case 2: {
                Main.sleepMe(3000);
                machine.cancelInterrupt();
            }
            case 3: {
                Main.sleepMe(3000);
                ExecutorService executorService = Executors.newSingleThreadExecutor();
                Future <?> future = executorService.submit(machine);
                future.cancel(true);
                executorService.shutdown();

            }
            case 4: {
                Main.sleepMe(3000);
                machine.setCanceled(true);
            }
            default: {

            }

        }


        try {
            machine.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("THIS IS THE END");
    }

    static void sleepMe(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
