import queue.Client;
import queue.Company;
import countDownLath.FileDownload;
import cyclicBarier.Home;
import exchanger.Task1;
import semaphore.SemThread;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(4);
        List<FileDownload> fileDownloads = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            fileDownloads.add(new FileDownload(i*1000, latch,
                    "FILE "+i));
        }
        fileDownloads.add(new FileDownload(10000,latch,"Nowy watek"));
        fileDownloads.forEach(FileDownload::start);
        latch.await();
        System.out.println("All files are on your desktop now");

        System.out.println("\n\n");
        ////////////////////////////////////////////////////CyclicBarier

        Home home = new Home();
        home.start();
        home.join();
        System.out.println("End home");

        System.out.println("\n\n");
        ////////////////////////////////////////////////////PHASER
        List<phaser.MyThread> myThreadList = new ArrayList<>();
        Phaser phaser = new Phaser();
        int currentPhase;

        System.out.println("Starting");
        myThreadList.add( new phaser.MyThread(phaser, "A"));
        myThreadList.add(new phaser.MyThread(phaser, "B"));
        myThreadList.add(new phaser.MyThread(phaser, "C"));


        // Wait for all threads to complete phase one.
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase "+ currentPhase + " Complete");
        System.out.println("Phase One Ended");

        // Wait for all threads to complete phase two.
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase "+ currentPhase + " Complete");
        System.out.println("Phase Two Ended");

        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase "+ currentPhase + " Complete");
        System.out.println("Phase Three Ended");

        phaser.arriveAndDeregister();
        if (phaser.isTerminated()) {
            System.out.println("Phaser is terminated");
        }
//
        Thread.sleep(2000);
        System.out.println("\n\n");
        ////////////////////////////////////////////////////EXCHANGER
        Exchanger<String> exchanger = new Exchanger<>();
        Task1 firstTask = new Task1(exchanger, "first");
        Task1 secondTask = new Task1(exchanger, "second");

        firstTask.start();
        secondTask.start();
        firstTask.join();
        secondTask.join();

        System.out.println(firstTask.getExchangedValue());//was first
        System.out.println(secondTask.getExchangedValue());//was second



        System.out.println("\n\n");
        ////////////////////////////////////////////////////SEMAPHORE

        Semaphore sem = new Semaphore(1);

        SemThread mt1 = new SemThread(sem, "A");
        SemThread mt2 = new SemThread(sem, "B");


        mt1.start();
        mt2.start();


        mt1.join();
        mt2.join();

        System.out.println("count: " + SemThread.getSharedValue());

        ////////////////////////////////////////////////////SynchronousQueue
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        Company company = new Company(synchronousQueue);
        Client client = new Client(synchronousQueue);
        company.start();
        client.start();




    }
}

