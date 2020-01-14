package cyclicBarier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Home extends Thread{
    public static CyclicBarrier newBarrier = new CyclicBarrier(2);
    List<Brick> bricks = new ArrayList<>();
    private int countBricks = 0;
    @Override
    public void run()
    {
        for (int i = 0; i < 3; i++) {
            bricks.add(new Brick());
        }
        bricks.forEach(Brick::start);

        try {
            newBarrier.await();
            System.out.println("Is the barrier broken? - " + Home.newBarrier.isBroken());
            bricks.forEach(brick -> countBricks+= brick.getCount());
            System.out.println("cyclicBarier.Home was build by " + countBricks + " bricks");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
