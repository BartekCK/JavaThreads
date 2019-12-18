import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        MyCollections myCollections = new MyCollections();

        Thread [] allThreads = new Thread[10];

        for (int i = 0; i < allThreads.length; i++) {
            if(i%2==0)
                allThreads[i] = new Writer(myCollections);
            else
                allThreads[i]= new Reader(myCollections);
        }

        for (Thread singleThread : allThreads) {
            singleThread.start();
        }


        for (Thread singleThread : allThreads){
            singleThread.join();
        }
        System.out.println("Threads are dead");


    }
}
