package queue;

import java.util.concurrent.SynchronousQueue;

public class Company extends Thread{
    private SynchronousQueue<Integer> synchronousQueue;

    public Company(SynchronousQueue<Integer> synchronousQueue) {
        this.synchronousQueue = synchronousQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("I'm a company and I produced "+i+" value");
                synchronousQueue.put(i);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
