package cyclicBarier;

public class Brick extends Thread{

    private int count = 0;

    public int getCount() {
        return count;
    }



    @Override
    public void run()
    {
        for(int i=0;i<500;i++){
            count++;
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        try {
            Home.newBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
