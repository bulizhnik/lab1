package lab2;

import java.util.ArrayList;

public class BallThread extends Thread {
    private lab2.Ball b;
    private ArrayList<lab2.Hole> holes;
    private lab2.BallCanvas canvas;
    private BallThread previous;

    public BallThread(lab2.Ball ball, ArrayList<lab2.Hole> holes, lab2.BallCanvas canvas, BallThread previous) {
        b = ball;
        this.holes = holes;
        this.canvas = canvas;
        this.previous = previous;
        if (ball.getColor() == lab2.BallColor.red){
            this.setPriority(Thread.MAX_PRIORITY);
        }
        else {

            this.setPriority(Thread.MIN_PRIORITY);
        }
    }

    @Override
    public void run() {
        try {
            if (previous!=null){
                previous.join();
            }
            for (int i = 1; i < 100000; i++) {
                if (holes.stream().anyMatch(x -> b.checkCollision(x))){
                    canvas.removeFromCanvas(b);
                    System.out.println("Thread gonna sleep = " + Thread.currentThread().getName());
                    return;
                }
                b.move();
                System.out.println("Thread name = " + Thread.currentThread().getName());
                Thread.sleep(5);
            }
        } catch (InterruptedException ex) {
        }
    }
}




