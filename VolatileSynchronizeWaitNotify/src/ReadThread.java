public class ReadThread extends Thread {

    private final Treasure treasure;

    public ReadThread(Treasure treasure) {
        this.treasure = treasure;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            treasure.readVolatile();
        }

        treasure.sleepMyDarling(500);

        for(int i=0;i<500;i++) {
            treasure.methodWithSynchronize();
        }

        treasure.sleepMyDarling(500);




        try{
            for (int i=0;i<10;i++){
                synchronized (this.treasure){

                    System.out.println("\nHay I'm READER and I get value " + treasure.getValue2() + " I want to change it to 0 !");
                    treasure.setValue2(0);
                    treasure.sleepMyDarling(200);

                    treasure.notify();
                    treasure.wait();

                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }





        }


}
