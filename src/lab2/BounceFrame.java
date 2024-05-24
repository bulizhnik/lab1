package lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BounceFrame extends JFrame {
    private lab2.BallCanvas canvas;
    protected JLabel ballsInHolesLabel; // Додайте JLabel для відображення лічильника
    private BallThread previous = null;
    public static final int WIDTH = 900;
    public static final int HEIGHT = 800;
    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce programm");
        this.canvas = new lab2.BallCanvas(this);
        System.out.println("In Frame Thread name = " + Thread.currentThread().getName());
        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);

        ballsInHolesLabel = new JLabel("Balls in holes: 0");
        ballsInHolesLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        content.add(ballsInHolesLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);
        JButton buttonBlueBall = new JButton("Blue Ball");
        JButton buttonRedBall = new JButton("Red Ball");
        JButton buttonStop = new JButton("Stop");

        ArrayList<lab2.Ball> balls = new ArrayList<lab2.Ball>();
        List<lab2.Ball> ballsSync = Collections.synchronizedList(balls);
        lab2.BallPaiter painter = new lab2.BallPaiter(ballsSync);
        painter.start();


        buttonBlueBall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lab2.Ball b = new lab2.Ball(canvas, lab2.BallColor.blue);
                canvas.add(b);
                ballsSync.add(b);
                lab2.BallThread thread = new lab2.BallThread(b, canvas.getHoles(), canvas, previous);
                previous = thread;
                thread.start();
                System.out.println("Thread name = " +
                        thread.getName());
            }
        });

        buttonRedBall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lab2.Ball b = new lab2.Ball(canvas, lab2.BallColor.red);
                canvas.add(b);
                ballsSync.add(b);
                lab2.BallThread thread = new lab2.BallThread(b, canvas.getHoles(), canvas, previous);
                previous = thread;
                thread.start();
                System.out.println("Thread name = " +
                        thread.getName());
            }
        });
        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });
        buttonPanel.add(buttonBlueBall);
        buttonPanel.add(buttonRedBall);
        buttonPanel.add(buttonStop);
        content.add(buttonPanel, BorderLayout.SOUTH);
    }
    public void updateBallsInHolesLabel(int ballsInHoles) {
        ballsInHolesLabel.setText("Balls in holes: " + ballsInHoles);
    }

}

