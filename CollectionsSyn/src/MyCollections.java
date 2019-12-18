import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

import static java.lang.Thread.sleep;

public class MyCollections {

    private Set<Integer> integerSet = new HashSet<>();
    private Set<Integer> synchronizedSet = Collections.synchronizedSet(new HashSet<>());
    private ConcurrentSkipListSet<Double> concurrentSkipListSet = new ConcurrentSkipListSet<>();
    private Set<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet<>();

    public void addValueToHashSet(Integer value){
        integerSet.add(value);
    }

    public Set<Integer> getIntegerSet() {
        return integerSet;
    }

    public Set<Integer> getSynchronizedSet() {
        return synchronizedSet;
    }

    public void sleepMyDarling(int millis){
        try {
            sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ConcurrentSkipListSet<Double> getConcurrentSkipListSet() {
        return concurrentSkipListSet;
    }

    public Set<Integer> getCopyOnWriteArraySet() {
        return copyOnWriteArraySet;
    }
}
