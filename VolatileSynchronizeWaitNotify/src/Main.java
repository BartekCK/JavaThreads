public class Main {

    public static void main(String[] args) throws InterruptedException {
        Treasure treasure = new Treasure();
        WriteThread writeThread = new WriteThread(treasure);
        ReadThread readThread = new ReadThread(treasure);


        writeThread.start();
        readThread.start();

        writeThread.join();
        readThread.join();

        System.out.println("All threads dead...");

    }
}
