package lab2;

import java.awt.*;
import java.awt.geom.Ellipse2D;

class Ball {
    private Component canvas;
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private int x = 0;
    private int y= 0;
    private int dx = 2;
    private int dy = 2;
    private int canvasWidth = 0;
    private int canvasHeight = 0;

    private lab2.BallColor ballcolor;

    private boolean active = true;

    public void setActive(boolean active) {
        this.active = active;
    }



    public Ball(Component c, lab2.BallColor color){
        this.canvas = c;
        this.ballcolor = color;
        x = 0;
        y = 0;
        canvasWidth = this.canvas.getWidth();
        canvasHeight = this.canvas.getHeight();

//        if(Math.random()<0.5){
//            x = new
//                    Random().nextInt(this.canvas.getWidth());
//            y = 0;
//        }else{
//            x = 0;
//            y = new
//                    Random().nextInt(this.canvas.getHeight());
//        }
    }
    public static void f(){
        int a = 0;
    }
    public void draw (Graphics2D g2){
        if (!active) {
            return;
        }
        if (this.ballcolor == lab2.BallColor.red) {
            g2.setColor(Color.RED);
        }
        else {
            g2.setColor(Color.BLUE);
        }
        g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));
    }
    public void move(){
        x += dx;
        y += dy;
        if(x < 0){
            x = 0;
            dx = -dx;
        }
        if(x + XSIZE >= canvasWidth){
            x = canvasWidth - XSIZE;

            dx = -dx;
        }
        if(y < 0){
            y = 0;
            dy = -dy;
        }
        if(y + YSIZE >= canvasHeight){
            y = canvasHeight - YSIZE;
            dy = -dy;
        }
//        this.canvas.repaint();
    }

    public void repaint(){
        this.canvas.repaint();
    }

    public lab2.BallColor getColor () {
        return ballcolor;
    }

    public boolean checkCollision(lab2.Hole hole) {
        int ballCenterX = x + XSIZE / 2;
        int ballCenterY = y + YSIZE / 2;
        int holeCenterX = hole.getHoleCenterX();
        int holeCenterY = hole.getHoleCenterY();
        return Math.sqrt(Math.pow(ballCenterX - holeCenterX, 2) + Math.pow(ballCenterY - holeCenterY, 2)) <= (double) lab2.Hole.getSize() / 2;
    }
}
