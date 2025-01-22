import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {

        RingBuffer<Integer> ringBuffer = new RingBuffer<>(12);

        try (ExecutorService executorService = Executors.newFixedThreadPool(20)) {

            executorService.execute(() -> ringBuffer.add(1));
            executorService.execute(() -> ringBuffer.add(2));
            executorService.execute(() -> ringBuffer.add(3));
            executorService.execute(() -> ringBuffer.add(4));
            executorService.execute(() -> ringBuffer.add(5));
            executorService.execute(() -> ringBuffer.add(6));
            executorService.execute(() -> ringBuffer.add(7));
            executorService.execute(() -> ringBuffer.add(8));
            executorService.execute(() -> ringBuffer.add(9));
            executorService.execute(() -> ringBuffer.add(10));
            executorService.execute(() -> ringBuffer.add(11));
            executorService.execute(() -> ringBuffer.add(12));
            executorService.execute(() -> ringBuffer.get(0));
            executorService.execute(() -> ringBuffer.get(4));
            executorService.execute(() -> ringBuffer.get(1));
            executorService.execute(() -> ringBuffer.get(2));

        }


    }
}