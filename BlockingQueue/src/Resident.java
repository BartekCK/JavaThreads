import java.util.Random;

public class Resident extends Thread {

    private Random random = new Random();

    @Override
    public void run() {
        while (true) {
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            checkApartment();

            if (Flat.isDayWithoutWork())
                break;
        }

    }

    private void checkApartment() {
        if (5 == random.nextInt(10)) {
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
