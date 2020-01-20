package com.company;

import java.util.ArrayList;
import java.util.List;

public class Machine extends Thread{

    private List<Nut> createdNuts = new ArrayList<>();

    private int typeCanceling;

    //Attribute
    private volatile boolean canceled = false;



    public Machine(int typeCanceling) {
        this.typeCanceling = typeCanceling;
        if(typeCanceling == 4)
            createdNuts.add(new Nut(666));

    }

    @Override
    public void run() {
        if (typeCanceling == 1){
            while (!canceled) {
                try {
                    createNut();
                } catch (InterruptedException e) {
                    System.out.println("INTERRUPT " + System.nanoTime() + " " + isInterrupted());
                }
            }
        }
        else if(typeCanceling == 2){

            try {
                while (!isInterrupted()) {
                    createNut();
                }
            } catch (Exception e) {
                System.out.println("INTERRUPT " + System.nanoTime() + " " + isInterrupted());
            }

        }
        else if(typeCanceling == 3){

            try {
                createNut();
            } catch (InterruptedException e) {
                System.out.println("INTERRUPT " + System.nanoTime() + " " + isInterrupted());
            }

        }
        else{

            try {
                createNut();
                if(canceled) {
                    if(startChecking())
                        throw new InterruptedException("me message");
                }

            } catch (InterruptedException e) {
                System.out.println("INTERRUPT " + System.nanoTime() + " " + isInterrupted());
            }

        }


        System.out.println("I'm going to STOP ...");
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public void cancelInterrupt(){
        System.out.println("CANCEL " + System.nanoTime());
        interrupt();
    }

    private void createNut() throws InterruptedException {

        sleep(1000);
        createdNuts.add(new Nut());
        showNut();

    }

    private void showNut(){
        createdNuts.forEach(System.out::println);
        System.out.println("\n");
    }

    private boolean startChecking(){
        if (createdNuts.get(0).getPrice() == 666)
            return true;
        return false;
    }
}
