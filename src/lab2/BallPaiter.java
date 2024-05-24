package lab2;

import java.util.List;

public class BallPaiter extends Thread {
    private List<lab2.Ball> balls;

    public BallPaiter(List<lab2.Ball> balls) {
        this.balls = balls;
    }

    @Override
    public void run() {
        try {
            while (true) {
                balls.forEach(lab2.Ball::repaint);
                Thread.sleep(5);
            }
        } catch (InterruptedException ex) {
        }
    }
}
