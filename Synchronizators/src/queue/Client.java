package queue;

import java.util.concurrent.SynchronousQueue;

public class Client extends Thread{

    private SynchronousQueue<Integer> synchronousQueue;

    public Client(SynchronousQueue<Integer> synchronousQueue) {
        this.synchronousQueue = synchronousQueue;
    }

    @Override
    public void run() {
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            try {
                int value = synchronousQueue.take();
                System.out.println("I'm a CLIENT and I get "+ value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
