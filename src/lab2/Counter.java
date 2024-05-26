package lab2;

public class Counter {

    private int value = 0;

    public void increment(){
        this.value++;
    }

    public void decrement(){
        this.value--;
    }

    @Override
    public String toString() {
        return "Counter output: " + value;
    }
}