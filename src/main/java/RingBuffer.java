import java.util.LinkedList;

public class RingBuffer<T> {

    private Integer indicator;
    private final int maxSize;
    private final LinkedList<T> buffer;

    public RingBuffer(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("Max size don't be 0");
        }
        this.maxSize = maxSize;
        this.buffer = new LinkedList<>();
        this.indicator = 0;
    }

    public void add(T element) {
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
            return;
        }
        buffer.add(element);
    }

    public T get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index don't be < 0");
        } else if (index >= buffer.size()) {
            throw new IllegalArgumentException("Index don't be > size");
        }
        return buffer.get(index);
    }
}