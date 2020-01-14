package semaphore;

import java.util.concurrent.Semaphore;


class Shared
{
    static int count = 0;
}


public class SemThread extends Thread{
    private Semaphore sem;
    private String threadName;
    public SemThread(Semaphore sem, String threadName)
    {
        super(threadName);
        this.sem = sem;
        this.threadName = threadName;
    }

    public static int getSharedValue(){
        return Shared.count;
    }

    @Override
    public void run() {


        if(this.getName().equals("A"))
        {
            System.out.println("Starting " + threadName);
            try
            {

                System.out.println(threadName + " is waiting for a permit.");


                sem.acquire();

                System.out.println(threadName + " gets a permit.");

                for(int i=0; i < 5; i++)
                {
                    Shared.count++;
                    System.out.println(threadName + ": " + Shared.count);

                    Thread.sleep(10);
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }


            System.out.println(threadName + " releases the permit.");
            sem.release();
        }

        // run by thread B
        else
        {
            System.out.println("Starting " + threadName);
            try
            {

                System.out.println(threadName + " is waiting for a permit.");


                sem.acquire();

                System.out.println(threadName + " gets a permit.");


                for(int i=0; i < 5; i++)
                {
                    Shared.count--;
                    System.out.println(threadName + ": " + Shared.count);

                    Thread.sleep(10);
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }

            System.out.println(threadName + " releases the permit.");
            sem.release();
        }
    }
}
