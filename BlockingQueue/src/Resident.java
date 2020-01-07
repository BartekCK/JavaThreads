import java.util.Random;

public class Resident extends Thread {

    private Random random = new Random();
    private final int PROBABILITY = 10;//10%
    private final int CHECK_APARTMENT_TIME = 10000;

    @Override
    public void run() {
        while (true) {
            try {
                sleep(CHECK_APARTMENT_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            checkApartment();

            if (Flat.isDayWithoutWork())
                break;
        }

    }

    private void checkApartment() {
        if (5 == random.nextInt(PROBABILITY)) {
            reportProblem();
        }
    }

    private void reportProblem() {
        String s = Flat.getDoList().get(random.nextInt(15)) + " zglosil " + Thread.currentThread().getName();
        try {
            Flat.getBlockingQueue().put(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
