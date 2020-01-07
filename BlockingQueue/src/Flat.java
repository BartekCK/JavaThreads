import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Flat implements Runnable {

    private final int COUNT_RESIDENT = 20;
    private static boolean dayWithoutWork = false;

    private List<Resident> residents = new ArrayList<>();
    private Conservator conservator = new Conservator();

    private static BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<>(10);
    private static List<String> doList = new ArrayList<>(Arrays.asList("ZEPSUTY_ZAMEK",
            "ZEPSUTE_DRZWI",
            "NIESZCZELNE_OKNA",
            "ZLY_ZAPACH",
            "CIEKNIE_Z_DACHU",
            "BRUDNA_SCIANA",
            "GRZANIE_NIESPRAWNE",
            "ZA_GORACO",
            "ZA_GLOSNO",
            "ZEPSUTA_WINDA",
            "ZACIETA_WINDA",
            "BRAK_PRADU",
            "NIE_MA_WODY",
            "NIE_DZIALA_SZLABAN",
            "SASIAD_ZAJAL_MOJE_MIEJSCE"));

    @Override
    public void run() {
        for (int i = 0; i < COUNT_RESIDENT; i++) {
            residents.add(new Resident());
        }
        residents.forEach(Thread::start);
        conservator.start();

        try {
            Thread.sleep(100000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dayWithoutWork = true;

        waitForIt();
    }

    private void waitForIt() {
        try {
            conservator.join();
            residents.forEach(resident -> {
                try {
                    resident.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static BlockingQueue<String> getBlockingQueue() {
        return blockingQueue;
    }

    public static List<String> getDoList() {
        return doList;
    }

    public static boolean isDayWithoutWork() {
        return dayWithoutWork;
    }
}
