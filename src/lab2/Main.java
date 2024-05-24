package lab2;

public class Main {
    private static Counter counter = new Counter();
    public static void main(String[] args) throws InterruptedException {
        Thread incrementThread = createThread(true);
        Thread decrementThread = createThread(false);

        incrementThread.start();
        decrementThread.start();

        incrementThread.join();
        decrementThread.join();

        System.out.println(counter.toString());
    }

    private static Thread createThread(boolean condition) {
        return new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                if (condition){
                    counter.increment();
                }else {
                    counter.decrement();
                }
            }
        });
    }
}