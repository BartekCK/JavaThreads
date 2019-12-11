public class Treasure {

    private volatile long value =0;
    private long value2 = 0;

    public  void writeVolatile() {
        long tmp = value & 0xFFFFFFFFL;
        tmp++;
        value = tmp | (tmp << 32);
    }
    public void readVolatile() {
        long tmp = value;
        long l = tmp & 0xFFFFFFFFL;
        long h = tmp >>> 32;
        System.err.println("!" + Long.toHexString(tmp) + " : " + h + " != " + l);
    }

    public synchronized void methodWithSynchronize(){
        long temp = value2;
        temp++;
        value2=temp;
        System.out.println(Thread.currentThread().getName() + " Value2 == " + value2 + " Should be 1000 at the end");
    }

    public void sleepMyDarling(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public long getValue2() {
        return value2;
    }

    public void setValue2(long value2) {
        this.value2 = value2;
    }
}
