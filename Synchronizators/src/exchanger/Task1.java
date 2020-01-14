package exchanger;

import java.util.concurrent.Exchanger;

public class Task1 extends Thread {
    private final Exchanger<String> exchanger;
    private final String value;
    private String exchangedValue;

    public Task1(Exchanger<String> exchanger, String value) {
        this.exchanger = exchanger;
        this.value = value;
    }
    @Override
    public void run() {
        try {
            exchangedValue = exchanger.exchange(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String getExchangedValue() {
        return exchangedValue;
    }

}
