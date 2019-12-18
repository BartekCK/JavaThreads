public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Flat());
        thread.start();


        thread.join();
        System.out.println("End");

    }
}
