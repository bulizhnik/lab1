package lab2;

public class Starter {

    public static void main(String[] args) {
        Starter printer = new Starter();
        Thread thread1 = new Thread(new LineWriter(printer, '-'));
        Thread thread2 = new Thread(new LineWriter(printer, '|'));

        thread1.start();
        thread2.start();
    }

    public void print(char symbol) {
        for (int i = 0; i < 100; i++) {
            System.out.print(symbol);
        }
    }
}

class LineWriter implements Runnable {
    private final Starter printer;
    private final char symbol;

    public LineWriter(Starter printer, char symbol) {
        this.printer = printer;
        this.symbol = symbol;
    }

    @Override
    public void run() {
        printer.print(symbol);
    }
}
