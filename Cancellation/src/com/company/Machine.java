package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Machine extends Thread{

    private List<Nut> createdNuts = new ArrayList<>();

    private int typeCanceling;

    //Attribute
    private volatile boolean canceled = false;



    public Machine(int typeCanceling) {
        this.typeCanceling = typeCanceling;;

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

            while(startChecking()) {
                try {
                    createNut();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
        List<Nut> asd = createdNuts.stream().filter(e -> e.getPrice() == 666).collect(Collectors.toList());
        if (asd.isEmpty())
            return true;
        else return false;
    }

    public void addPoison(Nut nut){
        createdNuts.add(nut);
    }
}
