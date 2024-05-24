//
//
//import java.util.concurrent.ArrayBlockingQueue;
//public class BufferExample {
//
//    private static final int BUFFER_SIZE = 10;
//    private static ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(BUFFER_SIZE);
//    public static void main(String[] args) {
//        Thread producerThread = new Thread(new Producer(), "ProducerThread");
//        Thread consumerAThread = new Thread(new ConsumerA(), "ConsumerAThread");
//        Thread consumerBThread = new Thread(new ConsumerB(), "ConsumerBThread");
//        producerThread.start();
//        consumerAThread.start();
//        consumerBThread.start();
//    }
//    static class Producer implements Runnable {
//        @Override
//        public void run() {
//            try {
//                for (int i = 1; i <= BUFFER_SIZE; i++) {
//                    buffer.put(i);
//                    System.out.println("Producer added: " + i);
//                    Thread.sleep(100); // Just for demonstration
//                }
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
//    }
//
//    static class ConsumerA implements Runnable {
//        @Override
//        public void run() {
//            try {
//                for (int i = 0; i < BUFFER_SIZE / 2; i++) {
//                    Integer value = buffer.take();
//                    System.out.println("Consumer A removed: " + value);
//                    Thread.sleep(200); // Just for demonstration
//                }
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
//    }
//    static class ConsumerB implements Runnable {
//        @Override
//        public void run() {
//            try {
//                for (int i = 0; i < BUFFER_SIZE / 2; i++) {
//                    Integer value = buffer.take();
//                    System.out.println("Consumer B removed: " + value);
//                    Thread.sleep(300); // Just for demonstration
//                }
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
//    }
//}