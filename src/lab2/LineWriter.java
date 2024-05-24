package lab2;

public class LineWriter extends Thread {
    private String symbol;

    public LineWriter(String symbol){
        this.symbol = symbol;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print(symbol);
        }
    }

}
