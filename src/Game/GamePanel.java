package Game;

import AfterGame.AfterGameFrame;
import Settings.SettingsPanel;
import Start.StartPagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {


    static Ball ball;

    MouseInputListener mouseInputListener;
    static boolean drawAimLine = true;

    static Brick newBrick1;
    static Brick newBrick2;
    static BallItems ballItem;
    static SpeedItems speedItem;
    static PowerUpItem powerUpItem;
    static DizzinessItem dizzinessItem;
    static DancingLightItem dancingLightItem;
    static EarthquakeItem earthquakeItem;
    static BombItem bombItem;
    static ReverseItem reverseItem;
    static ChanceItem chanceItem;
    static int xFirstBrick;
    static int xSecondBrick;
    static int xBallItem;
    static int xOtherItems;

    public static ArrayList<Brick> bricks = new ArrayList<>();
    public static ArrayList<Ball> balls = new ArrayList<>();
    public static ArrayList<BallItems> ballItems = new ArrayList<>();
    public static ArrayList<SpeedItems> speedItems = new ArrayList<>();
    public static ArrayList<PowerUpItem> powerUpItems = new ArrayList<>();
    public static ArrayList<DizzinessItem> dizzinessItems = new ArrayList<>();
    public static ArrayList<DancingLightItem> dancingLightItems = new ArrayList<>();
    public static ArrayList<EarthquakeItem> earthquakeItems = new ArrayList<>();
    public static ArrayList<BombItem> bombItems = new ArrayList<>();
    public static ArrayList<ReverseItem> reverseItems = new ArrayList<>();
    public static ArrayList<ChanceItem> chanceItems = new ArrayList<>();

    static int gameRound = 1;
    public static int number;
    public static int seconds;
    public static int minutes;
    Timer timer;
    public static boolean pauseGame = false;




    GamePanel() {
        init();

    }

    public void init() {
        GameFrame.gameIsRunning = true;
        gameTimer();
        timer.start();
        this.setBackground(new Color(0x0D283B));
        newBall(165, 430);
        newBrick();
        newBallItems();
        newSpeedItems();
        newPowerUpItems();
        newDizzinessItems();
        newDancingLightItems();
        newEarthquakeItems();
        newBombItems();
        newReverseItems();
        newChanceItems();
        //addButton();
        mouseInputListener = new MouseInputListener();
        this.addMouseListener(new MouseInputListener());
        this.addMouseMotionListener(new MouseInputListener());
        seconds = 0;
        minutes = 0;



    }

    public static void newBall(int x, int y) {
        ball = new Ball(x, y);
        balls.add(0, ball);
    }


    public static void newBrick() {
        xFirstBrick = (int) (7*Math.random());
        newBrick1 = new Brick(xFirstBrick * Brick.width, 85, gameRound );
        xSecondBrick = (int) (7*Math.random());
        xBallItem = (int) (7*Math.random());
        xOtherItems = (int) (7*Math.random());
        if (xSecondBrick == xFirstBrick) {
            while (xSecondBrick == xFirstBrick) {
                xSecondBrick = (int) (7*Math.random());
            }
        }
        if (xBallItem == xFirstBrick || xBallItem == xSecondBrick) {
            while (xBallItem == xFirstBrick || xBallItem == xSecondBrick) {
                xBallItem = (int) (7*Math.random());
            }
        }
        if (xOtherItems == xFirstBrick || xOtherItems == xSecondBrick || xOtherItems == xBallItem) {
            while (xOtherItems == xFirstBrick || xOtherItems == xSecondBrick || xOtherItems == xBallItem) {
                xOtherItems = (int) (7*Math.random());
            }
        }
        newBrick2 = new Brick(xSecondBrick * Brick.width, 85, gameRound );
        if (StartPagePanel.gameLevel == 0) {
            newBrick2.brickValue += number;
            newBrick1.brickValue += number;
        } else if (StartPagePanel.gameLevel == 1) {
            newBrick2.brickValue = 0;
            newBrick1.brickValue += number;
        } else if (StartPagePanel.gameLevel == 2) {
            newBrick2.brickValue += 2*number;
            newBrick1.brickValue += 2*number;
        }
        newBrick1.brickMainValue = newBrick1.brickValue;
        newBrick2.brickMainValue = newBrick2.brickValue;
        bricks.add(0, newBrick1);
        bricks.add(0, newBrick2);
    }

    public static void newBallItems() {
        if (StartPagePanel.gameLevel == 0 || StartPagePanel.gameLevel == 1) {
            ballItem = new BallItems(xBallItem * Brick.width + 10, 90);
            ballItems.add(0, ballItem);
        } else if (StartPagePanel.gameLevel == 2) {
            if ((gameRound + number) % 2 == 1) {
                ballItem = new BallItems(xBallItem * Brick.width + 10, 90);
                ballItems.add(0, ballItem);
            }
            else {
                ballItem = new BallItems(xBallItem * Brick.width + 10, 90);
                ballItem.value = 0;
                ballItems.add(0, ballItem);
            }
        }

    }

    public static void newSpeedItems() {
        if ((gameRound + number)%30 == 15) {
            speedItem = new SpeedItems(xOtherItems * Brick.width, 85, 1);
            speedItems.add(speedItem);
        }
        else {
            speedItem = new SpeedItems(xOtherItems * Brick.width, 85, 0);
            speedItems.add(speedItem);
        }
    }

    public static void newPowerUpItems() {
        if (StartPagePanel.gameLevel == 0) {
            if ((gameRound + number)%10 == 5) {
                powerUpItem = new PowerUpItem(xOtherItems * Brick.width, 85, 1);
                powerUpItems.add(powerUpItem);
            }
            else {
                powerUpItem = new PowerUpItem(xOtherItems * Brick.width, 85, 0);
                powerUpItems.add(powerUpItem);
            }
        }
        else {
            if ((gameRound + number)%30 == 5) {
                powerUpItem = new PowerUpItem(xOtherItems * Brick.width, 85, 1);
                powerUpItems.add(powerUpItem);
            }
            else {
                powerUpItem = new PowerUpItem(xOtherItems * Brick.width, 85, 0);
                powerUpItems.add(powerUpItem);
            }
        }

    }

    public static void newDizzinessItems() {
        if ((gameRound + number)%30 == 9) {
            dizzinessItem = new DizzinessItem(xOtherItems * Brick.width, 85, 1);
            dizzinessItems.add(dizzinessItem);
        }
        else {
            dizzinessItem = new DizzinessItem(xOtherItems * Brick.width, 85, 0);
            dizzinessItems.add(dizzinessItem);
        }
    }

    public static void newDancingLightItems() {
        if ((gameRound + number)%30 == 17) {
            dancingLightItem = new DancingLightItem(xOtherItems * Brick.width, 85, gameRound);
            dancingLightItem.value += number;
            dancingLightItems.add(dancingLightItem);
        }
        else {
            dancingLightItem = new DancingLightItem(xOtherItems * Brick.width, 85, 0);
            dancingLightItems.add(dancingLightItem);
        }
    }

    public static void newEarthquakeItems() {
        if ((gameRound + number)%30 == 19) {
            earthquakeItem = new EarthquakeItem(xOtherItems * Brick.width, 85, gameRound);
            earthquakeItem.value += number;
            earthquakeItems.add(earthquakeItem);
        }
        else {
            earthquakeItem = new EarthquakeItem(xOtherItems * Brick.width, 85, 0);
            earthquakeItems.add(earthquakeItem);
        }
    }

    public static void newBombItems() {
        if ((gameRound + number)%30 == 8) {
            bombItem = new BombItem(xOtherItems * Brick.width, 85, 1);
            bombItems.add(bombItem);
        }
        else {
            bombItem = new BombItem(xOtherItems * Brick.width, 85, 0);
            bombItems.add(bombItem);
        }
    }

    public static void newReverseItems() {
        if ((gameRound + number)%30 == 26) {
            reverseItem = new ReverseItem(xOtherItems * Brick.width, 85, 1);
            reverseItems.add(reverseItem);
        }
        else {
            reverseItem = new ReverseItem(xOtherItems * Brick.width, 85, 0);
            reverseItems.add(reverseItem);
        }
    }
    public static void newChanceItems() {
        if ((gameRound + number) == 50) {
            chanceItem = new ChanceItem(xOtherItems * Brick.width, 85, 1);
            chanceItems.add(chanceItem);
        }
        else {
            chanceItem = new ChanceItem(xOtherItems * Brick.width, 85, 0);
            chanceItems.add(chanceItem);
        }
    }

    public void run() {

        while (GameFrame.gameIsRunning) {
            while (pauseGame) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

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
        ball.startingNewLoop();
        newBrick1.update();
        newBrick2.update();
        ballItem.update();
        speedItem.update();
        powerUpItem.update();
        dizzinessItem.update();
        dancingLightItem.update();
        earthquakeItem.update();
        bombItem.update();
        reverseItem.update();
        chanceItem.update();
        restartingGame();

    }

    public void draw() {


    }

    public void drawYouLost(Graphics g) {
        g.setColor(new Color(0x1C8F09));
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("YOU LOST!", 100, 275);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawScore(g);
        drawTimer(g);
        drawBallNumber(g);
        drawPauseResume(g);
        ball.draw(g, ball.x, ball.y, ball.ballSize);
        newBrick1.draw(g, newBrick1.x);
        newBrick2.draw(g, newBrick2.x);
        ballItem.draw(g, ballItem.x);
        speedItem.draw(g, speedItem.x);
        powerUpItem.draw(g, powerUpItem.x);
        dizzinessItem.draw(g, dizzinessItem.x);
        dancingLightItem.draw(g, dancingLightItem.x);
        earthquakeItem.draw(g, earthquakeItem.x);
        bombItem.draw(g, ballItem.x);
        reverseItem.draw(g, reverseItem.x);
        chanceItem.draw(g, chanceItem.x);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.fillRect(0, 80, 350, 5);
        g2d.fillRect(0, 450, 350, 5);
        if (Brick.checkForEndGame()) {
            drawYouLost(g);
        }
        g.dispose();
    }

    public void drawScore(Graphics g) {
        g.setColor(new Color(0x1C8F09));
        g.setFont(new Font("Arial", Font.PLAIN  , 18));
        g.drawString("SCORE : " + String.valueOf(Brick.score), 10, 20);
    }

    public void drawTimer(Graphics g) {
        g.setColor(new Color(0x1C8F09));
        g.setFont(new Font("Arial", Font.PLAIN  , 18));
        g.drawString(String.valueOf(minutes) + " : " + seconds, 275, 20);
    }

    public void drawBallNumber(Graphics g) {
        g.setColor(new Color(0x1C8F09));
        g.setFont(new Font("Arial", Font.PLAIN  , 18));
        g.drawString("Balls : " + balls.size(), 10, 40);
    }

    public void drawPauseResume(Graphics g) {
        g.setColor(new Color(0x770404));
        g.fillRect(250, 35, 75, 35);
        g.setColor(new Color(0x1C8F09));
        g.drawString("Pause", 260, 57);

        g.setColor(new Color(0x770404));
        g.fillRect(170, 35, 75, 35);
        g.setColor(new Color(0x1C8F09));
        g.drawString("Resume", 175, 57);

    }

    public void paint(Graphics g) {
        super.paint(g);
        if (drawAimLine && (SettingsPanel.aimNumber == 0)) {
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


    public void gameTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (GameFrame.gameIsRunning) {
                    seconds++;
                    if (seconds == 60) {
                        minutes++;
                        seconds = 0;
                    }
                }

            }
        });
    }

    public void restartingGame() {
        if (Brick.checkForEndGame()) {
            number = 0;
            seconds = 0;
            minutes = 0;
            bricks.clear();
            balls.clear();
            ballItems.clear();
            speedItems.clear();
            powerUpItems.clear();
            dizzinessItems.clear();
            dancingLightItems.clear();
            earthquakeItems.clear();
            bombItems.clear();
            reverseItems.clear();
            chanceItems.clear();
            Brick.score = 0;
            repaint();
        }
    }
}
