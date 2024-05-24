//import javax.swing.*;
//import java.awt.*;
//import java.util.ArrayList;
//
//public class BallCanvas extends JPanel {
//    private ArrayList<Ball> balls = new ArrayList<>();
//
//    public void add(Ball b) {
//        balls.add(b);
//    }
//
//
//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2 = (Graphics2D) g;
//
//        // Малюємо кульки
//        for (Ball b : balls) {
//            b.draw(g2);
//        }
//    }
//}

package lab2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BallCanvas extends JPanel {
    private ArrayList<lab2.Ball> balls = new ArrayList<>();
    private ArrayList<lab2.Hole> holes = new ArrayList<>();
    private int ballsInHoles = 0;
    private static final int NUM_HOLES = 7;
    private static final int CANVAS_WIDTH = 850;
    private static final int CANVAS_HEIGHT = 750;
    private lab2.BounceFrame frame;
    public BallCanvas(lab2.BounceFrame frame) {
        this.frame = frame;
        createHoles();
    }

    private void createHoles() {
        Random rand = new Random();
        for (int i = 0; i < NUM_HOLES; i++) {
            int x, y;
            boolean intersects;
            do {
                intersects = false;
                x = rand.nextInt(CANVAS_WIDTH - lab2.Hole.getSize());
                y = rand.nextInt(CANVAS_HEIGHT - lab2.Hole.getSize());
                for (lab2.Hole hole : holes) {
                    if (Math.abs(x - hole.getX()) < lab2.Hole.getSize() && Math.abs(y - hole.getY()) < lab2.Hole.getSize()) {
                        intersects = true;
                        break;
                    }
                }
            } while (intersects);
            lab2.Hole hole = new lab2.Hole(x, y);
            holes.add(hole);
        }
    }

    public ArrayList<lab2.Hole> getHoles() {
        return holes;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (lab2.Hole hole : holes) {
            hole.drawHole(g2);
        }
        for (lab2.Ball ball : balls) {
            ball.draw(g2);
        }
    }

    public void add(lab2.Ball b) {
        balls.add(b);
    }

    public void removeFromCanvas(lab2.Ball b) {
        ballsInHoles++;
        balls.remove(b); // Видаляємо кулю зі списку куль на полотні
        b.setActive(false); // Позначаємо кулю як неактивну
        repaint(); // Перемальовуємо полотно без кулі
        frame.updateBallsInHolesLabel(ballsInHoles);
    }

    public int getBallsInHoles() {
        return ballsInHoles; // Повертаємо поточну кількість куль у дірках
    }
}

