import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class RingBuffer<T> {

    private Integer indicator;
    private final int maxSize;
    private final List<T> buffer;
    private final ReentrantLock reentrantLock;

    public RingBuffer(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("Max size don't be 0");
        }
        this.maxSize = maxSize;
        this.buffer = Collections.synchronizedList(new ArrayList<>());
        this.indicator = 0;
        this.reentrantLock = new ReentrantLock();
    }

    public void add(T element) {
        reentrantLock.lock();
        if (buffer.size() == maxSize) {
            int localIndicator = (indicator + 1);
            boolean local = true;
            while (local) {
                if ((localIndicator != maxSize)) {
                    buffer.set(indicator, element);
                    indicator++;
                    local = false;
                } else if ((localIndicator == maxSize)) {
                    indicator = 0;
                    localIndicator = indicator;
                }
            }

        } else {
            buffer.add(element);
        }
        reentrantLock.unlock();
    }

    public T get(int index) {
        reentrantLock.lock();
        try {
            if (index < 0) {
                throw new IllegalArgumentException("Index don't be < 0");
            } else if (index >= buffer.size()) {
                throw new IllegalArgumentException("Index don't be > size");
            }
            return buffer.get(index);
        } finally {
            reentrantLock.unlock();
        }
    }
}