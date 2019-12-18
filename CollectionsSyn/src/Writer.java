import java.util.Collection;
import java.util.Random;

public class Writer extends Thread{

    private static int i=0;
    private final MyCollections myCollections;

    public Writer(MyCollections myCollections) {
        this.myCollections = myCollections;
    }
    @Override
    public void run() {

        synchronized (myCollections){
            System.out.println(Thread.currentThread().getName()+" CURRENT WRITER");
            i++;
            myCollections.addValueToHashSet(i);
        }

        myCollections.sleepMyDarling(400);

        Random random = new Random();


        myCollections.getSynchronizedSet().add(random.nextInt(200));
        myCollections.sleepMyDarling(400);

        myCollections.getConcurrentSkipListSet().add(random.nextDouble());

        //myCollections.sleepMyDarling(1);

        myCollections.getCopyOnWriteArraySet().add(random.nextInt(7));

    }
}

