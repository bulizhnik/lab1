package lab2;

public class Starter {
    private final Object lock = new Object();
    private boolean turn = true; // true - перший потік, false - другий потік

    public static void main(String[] args) {
        Starter printer = new Starter();
        Thread thread1 = new Thread(new LineWriter(printer, '-', true));
        Thread thread2 = new Thread(new LineWriter(printer, '|', false));

        thread1.start();
        thread2.start();
    }

    public void print(char symbol, boolean isFirstThread) {
        synchronized (lock) {
            for (int i = 0; i < 100; i++) {
                while (turn != isFirstThread) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(symbol);
                turn = !turn;
                lock.notifyAll();
            }
        }
    }
}

class LineWriter implements Runnable {
    private final Starter printer;
    private final char symbol;
    private final boolean isFirstThread;

    public LineWriter(Starter printer, char symbol, boolean isFirstThread) {
        this.printer = printer;
        this.symbol = symbol;
        this.isFirstThread = isFirstThread;
    }

    @Override
    public void run() {
        printer.print(symbol, isFirstThread);
    }
}
