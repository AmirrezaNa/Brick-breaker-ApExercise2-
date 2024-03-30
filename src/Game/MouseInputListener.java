package Game;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MouseInputListener implements MouseListener, MouseMotionListener {


    static Point endPoint;
    static Point startPoint;
    static Point middlePoint;

    MouseInputListener() {


    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (Ball.ballOnDownSide) {
            GamePanel.drawAimLine = true;
            startPoint = e.getPoint();
            middlePoint = e.getPoint();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (Ball.ballOnDownSide) {
            endPoint = e.getPoint();
            throwTheBall();
            GamePanel.drawAimLine = false;
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (Ball.ballOnDownSide) {
            middlePoint = e.getPoint();
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


    public void throwTheBall() {
        if (Ball.ballOnDownSide) {
            Ball.ballOnDownSide = false;
            double x1 = startPoint.x;
            double y1 = startPoint.y;
            double x2 = endPoint.x;
            double y2 = endPoint.y;
            final int[] numberOfBalls = {GamePanel.balls.size()};


            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    if (numberOfBalls[0] > 0) {
                        Ball ball = GamePanel.balls.get(numberOfBalls[0] - 1);
                        if (x2 > x1 && y2 > y1) {

                            ball.dx = -(((x2 - x1) / ((x2 - x1) + (y2 - y1))) * 30);
                            ball.dy = -(30 - (((x2 - x1) / ((x2 - x1) + (y2 - y1))) * 30));
                        }
                        if (x2 <= x1 && y2 > y1) {

                            ball.dx = (((x1 - x2) / ((x1 - x2) + (y2 - y1))) * 30);
                            ball.dy = -(30 - (((x1 - x2) / ((x1 - x2) + (y2 - y1))) * 30));
                        }
                        numberOfBalls[0]--;
                    }
                }
            };
            timer.scheduleAtFixedRate(task, 0, 100);

        }

    }


}
