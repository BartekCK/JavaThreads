public class Reader extends Thread {

    private final MyCollections myCollections;

    public Reader(MyCollections myCollections) {
        this.myCollections = myCollections;
    }

    @Override
    public void run() {

        synchronized (myCollections){
            System.out.println(Thread.currentThread().getName()+" START");
            myCollections.getIntegerSet().forEach(System.out::println);
            System.out.println("END");
        }

        myCollections.sleepMyDarling(500);

        System.out.println();
        myCollections.getSynchronizedSet().forEach(System.out::println);

        myCollections.sleepMyDarling(400);
        synchronized (myCollections){
            System.out.println(Thread.currentThread().getName()+" START");
            myCollections.getConcurrentSkipListSet().forEach(System.out::println);
            System.out.println("END");
        }

        myCollections.sleepMyDarling(1);
        System.out.println("\n");
        myCollections.getCopyOnWriteArraySet().forEach(System.out::println);
    }
}
