package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    int count = 0;
    AtomicInteger atomicInteger = new AtomicInteger(0);

    public void increment() {
        this.count = this.count + 1;
    }

    synchronized public void incrementSync() {
        this.count = this.count + 1;
    }

    public void incrementSyncBlock() {
        synchronized (this) {
            count = count + 1;
        }
    }

    public void incrementAtomic() {
        atomicInteger.incrementAndGet();
    }
}
