public class Main {
    public static void main(String[] args) {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(5);
        ringBuffer.add(1);
        ringBuffer.add(2);
        ringBuffer.add(3);
        ringBuffer.add(4);
        ringBuffer.add(5);
        ringBuffer.add(6);

        Integer i = ringBuffer.get(0);
        System.out.println(i);


    }
}