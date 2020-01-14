package phaser;

import java.util.concurrent.Phaser;

public class MyThread implements Runnable {
    Phaser phaser;
    String title;

    public MyThread(Phaser phaser,
                    String title)
    {
        this.phaser = phaser;
        this.title = title;

        phaser.register();
        new Thread(this).start();
    }

    @Override
    public void run()
    {
        System.out.println("Thread: " + title
                + "\nPhase One Started");
        phaser.arriveAndAwaitAdvance();

        // Stop execution to prevent jumbled output
        try {
            Thread.sleep(10);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread: " + title
                + "\nPhase Two Started");
        phaser.arriveAndAwaitAdvance();

        // Stop execution to prevent jumbled output
        try {
            Thread.sleep(10);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread: " + title
                + "\nPhase Three Started");
        phaser.arriveAndDeregister();
    }


}
