package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {


    static Ball ball;

    MouseInputListener mouseInputListener;
    static boolean drawAimLine = true;

    static Brick newBrick1;
    static Brick newBrick2;

    static ArrayList<Brick> bricks = new ArrayList<>();
    static ArrayList<Ball> balls = new ArrayList<>();
    static Ball otherBalls;
    static int gameRound = 1;
    static int number;



    GamePanel() {
        init();

    }

    public void init() {
        GameFrame.gameIsRunning = true;
        this.setBackground(new Color(0x0D283B));
        newBall(165, 430);
        newBrick();
        mouseInputListener = new MouseInputListener();
        this.addMouseListener(new MouseInputListener());
        this.addMouseMotionListener(new MouseInputListener());

    }


    public static void newBall(int x, int y) {
        ball = new Ball(x, y);
        balls.add(0, ball);
    }


    public static void newBrick() {
        int xFirstBrick = (int) (7*Math.random());
        newBrick1 = new Brick(xFirstBrick * Brick.width, 85, gameRound );
        int xSecondBrick = (int) (7*Math.random());
        if (xSecondBrick == xFirstBrick) {
            while (xSecondBrick == xFirstBrick) {
                xSecondBrick = (int) (7*Math.random());
            }
        }
        newBrick2 = new Brick(xSecondBrick * Brick.width, 85, gameRound );
        newBrick1.brickValue += number;
        newBrick2.brickValue += number;
        newBrick1.brickMainValue = newBrick1.brickValue;
        newBrick2.brickMainValue = newBrick2.brickValue;
        bricks.add(0, newBrick1);
        bricks.add(0, newBrick2);
    }


    public void run() {

        while (GameFrame.gameIsRunning) {

            //update
            update();


            // draw
            draw();


            repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void update() {
        orderingBalls();
        ball.update();
        newBrick1.update();
        newBrick2.update();
    }

    public void draw() {


    }

    public void drawYouLust(Graphics g) {
        g.setColor(new Color(0x1C8F09));
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("YOU LUST!", 100, 275);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawScore(g);
        ball.draw(g, ball.x, ball.y, ball.ballSize);
        newBrick1.draw(g, newBrick1.x);
        newBrick2.draw(g, newBrick2.x);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.fillRect(0, 80, 350, 5);
        g2d.fillRect(0, 450, 350, 5);
        if (Brick.checkForEndGame()) {
            drawYouLust(g);
            GameFrame.gameIsRunning = false;
        }
        g.dispose();
    }

    public void drawScore(Graphics g) {
        g.setColor(new Color(0x1C8F09));
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("SCORE : " + String.valueOf(Brick.score), 10, 20);
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (drawAimLine) {
            if (MouseInputListener.startPoint != null) {

                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.RED);
                if (MouseInputListener.middlePoint.x > ball.x) {
                    float[] dashingPattern1 = {2f, 2f};
                    Stroke stroke1 = new BasicStroke(2f, BasicStroke.CAP_BUTT,
                            BasicStroke.JOIN_MITER, 1.0f, dashingPattern1, 2.0f);

                    g2d.setStroke(stroke1);
                    g2d.drawLine((int) ball.x + (Ball.ballSize/2), (int) ball.y + (Ball.ballSize/2),
                            (int) (MouseInputListener.middlePoint.x - (2 * Math.abs(ball.x - MouseInputListener.middlePoint.x))),
                            (int) (MouseInputListener.middlePoint.y - (2 * Math.abs(ball.x - MouseInputListener.middlePoint.y))));
                } else {
                    float[] dashingPattern1 = {2f, 2f};
                    Stroke stroke1 = new BasicStroke(2f, BasicStroke.CAP_BUTT,
                            BasicStroke.JOIN_MITER, 1.0f, dashingPattern1, 2.0f);

                    g2d.setStroke(stroke1);
                    g2d.drawLine((int)ball.x + (Ball.ballSize/2), (int) ball.y + (Ball.ballSize/2),
                            (int) (MouseInputListener.middlePoint.x + (2 * Math.abs(ball.x - MouseInputListener.middlePoint.x))),
                            (int) (MouseInputListener.middlePoint.y - (2 * Math.abs(ball.y - MouseInputListener.middlePoint.y))));

                }

            }
        }


    }

    public void orderingBalls() {
        int allBallsX = 0;
        for (Ball ball : balls) {
            Rectangle ballRect = new Rectangle((int) ball.x, (int) ball.y, Ball.ballSize, Ball.ballSize);
            Rectangle downSideRect = new Rectangle(0, 450, 400, 5);
            if (ballRect.y + ballRect.height >= downSideRect.y) {
                allBallsX = (int) ball.x;
                break;
            }
        }
        for (Ball ball : GamePanel.balls) {
            Rectangle ballRect = new Rectangle((int) ball.x, (int) ball.y, Ball.ballSize, Ball.ballSize);
            Rectangle downSideRect = new Rectangle(0, 450, 400, 5);
            if (ballRect.y + ballRect.height >= downSideRect.y) {
                ball.x = allBallsX;
            }
        }
    }

}
