package lab2;

public class Counter {

    private int value = 0;

    public synchronized void increment() {
        this.value++;
    }

    public synchronized void decrement() {
        this.value--;
    }

    @Override
    public String toString() {
        return "Counter output: " + value;
    }
}