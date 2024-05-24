package lab2;

import java.awt.*;

public class Hole {
    private int x;
    private int y;
    private static final int SIZE = 20;
    private int holeCenterX;
    private int holeCenterY;
    public Hole(int x, int y) {
        this.x = x;
        this.y = y;
        this.holeCenterX = x + SIZE / 2;
        this.holeCenterY = y + SIZE / 2;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getSize() {
        return SIZE;
    }

    public void drawHole(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        g2.fillOval(x, y, SIZE, SIZE);
    }

    public int getHoleCenterY() {
        return holeCenterY;
    }

    public void setHoleCenterY(int holeCenterY) {
        this.holeCenterY = holeCenterY;
    }

    public int getHoleCenterX() {
        return holeCenterX;
    }

    public void setHoleCenterX(int holeCenterX) {
        this.holeCenterX = holeCenterX;
    }
}
