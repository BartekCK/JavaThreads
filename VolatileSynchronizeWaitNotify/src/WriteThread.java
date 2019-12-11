public class WriteThread extends Thread {

    private final Treasure treasure;

    public WriteThread(Treasure treasure) {
        this.treasure = treasure;
    }

    @Override
    public void run() {

        for(int i=0;i<10;i++) {
            treasure.writeVolatile();
        }

        treasure.sleepMyDarling(500);

        for(int i=0;i<500;i++) {
            treasure.methodWithSynchronize();
        }

        treasure.sleepMyDarling(500);


        try{
            for (int i=0;i<10;i++){
                synchronized (this.treasure){
                    treasure.wait();

                    System.out.println("Hay I'm WRITER and I get value = " + treasure.getValue2() + " and I change it to 66");
                    treasure.setValue2(66);

                    treasure.notify();


                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }




    }




}
