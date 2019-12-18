import java.util.Random;

public class Conservator extends Thread {

    Random random = new Random();

    @Override
    public void run() {
        while (true) {
            fixProblem();

            if (Flat.isDayWithoutWork())
                break;
        }

    }

    private void fixProblem() {
        try {
            String job = Flat.getBlockingQueue().take();
            sleep(random.nextInt(5000));
            System.out.println("Wlasnie naprawilem " + job);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
