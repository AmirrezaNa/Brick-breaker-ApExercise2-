package Game;

import Start.StartPage;
import Start.StartPagePanel;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Ball {

    double x, y, dx, dy;
    static final int ballSize = 20;

    static boolean ballOnDownSide = false;
    static boolean ballInAir = false;
    public static boolean colorChosen;


    Ball(int x, int y) {
        this.x = x;
        this.y = y;
        dx = 0;
        dy = 0;

    }

    public void update() {
        for (Ball ball : GamePanel.balls) {
            if (SpeedItems.speedUp) {
                ball.x += 2 * ball.dx;
                ball.y += 2 * ball.dy;
            }
            else {
                ball.x += ball.dx;
                ball.y += ball.dy;
            }

            Rectangle ballRect = new Rectangle((int) ball.x, (int) ball.y, ballSize, ballSize);
            Rectangle downSideRect = new Rectangle(0, 450, 400, 5);
            if (ball.x < ballSize / 2 || ball.x > GameFrame.width - 35) {
                ball.dx = -ball.dx;
            }
            if (ball.y < 95) {
                ball.dy = -ball.dy;
            }
            if (ballRect.y + ballRect.height >= downSideRect.y) {
                ball.dy = 0;
                ball.dx = 0;

            } else {
                ballInAir = true;
            }
            for (Brick brick : GamePanel.bricks) {
                if (brick.brickValue > 0) {
                    Rectangle brickRect = new Rectangle(brick.x, brick.y, Brick.width, Brick.height);
                    if (ballRect.intersects(brickRect)) {
                        if (ballRect.y <= brickRect.y) {
                            ball.dy = -ball.dy;
                        }

                        if (ballRect.y > brickRect.y) {
                            ball.dy = -ball.dy;
                        } else {
                            ball.dx = -ball.dx;
                        }
                        if (PowerUpItem.powerUp) {
                            brick.brickValue -= 2;
                        }
                        else {
                            brick.brickValue--;
                        }
                        if (brick.brickValue == 0) {
                            Brick.score = Brick.score + (brick.brickMainValue - (GamePanel.minutes*5));
                        }
                    }

                }

            }
        }


    }

    public void draw(Graphics g, double x, double y, double ballSize) {
        if (DancingLightItem.dancingLightSeconds % 2 == 0) {
            if (colorChosen) {
                g.setColor(StartPagePanel.ballColor);
                g.fillOval((int) x, (int) y, (int) ballSize, (int) ballSize);
                for (Ball ball : GamePanel.balls) {
                    g.fillOval((int) ball.x, (int) ball.y, (int) ballSize, (int) ballSize);
                }
            }
            else {
                g.setColor(new Color(0x0C4203));
                g.fillOval((int) x, (int) y, (int) ballSize, (int) ballSize);
                for (Ball ball : GamePanel.balls) {
                    g.fillOval((int) ball.x, (int) ball.y, (int) ballSize, (int) ballSize);
                }
            }
        }
        else {
            g.setColor(new Color(0x9D15DC));
            g.fillOval((int) x, (int) y, (int) ballSize, (int) ballSize);
            for (Ball ball : GamePanel.balls) {
                g.fillOval((int) ball.x, (int) ball.y, (int) ballSize, (int) ballSize);
            }
        }


    }

    public void startingNewLoop() {
        boolean allBallsDown = true;
        for (Ball ball : GamePanel.balls){
            Rectangle ballRect = new Rectangle((int) ball.x, (int) ball.y, ballSize, ballSize);
            Rectangle downSideRect = new Rectangle(0, 450, 400, 5);
            if (ballRect.y + ballRect.height < downSideRect.y){
                allBallsDown = false;
            }
        }
        if (allBallsDown) {
            ballOnDownSide = true;
            if (ballInAir) {
                GamePanel.number++;
                GamePanel.newBrick();
                GamePanel.newBallItems();
                GamePanel.newSpeedItems();
                GamePanel.newPowerUpItems();
                GamePanel.newDizzinessItems();
                GamePanel.newDancingLightItems();
                ballInAir = false;
                for (Brick brick : GamePanel.bricks) {
                    if (GamePanel.bricks.indexOf(brick) == 0 || GamePanel.bricks.indexOf(brick) == 1) {
                        continue;
                    } else {
                        brick.y += Brick.height;
                    }
                }
                for (BallItems ballItem : GamePanel.ballItems) {
                    if (GamePanel.ballItems.indexOf(ballItem) == 0) {
                        continue;
                    } else {
                        ballItem.y += Brick.height;
                    }
                }
                for (SpeedItems speedItem : GamePanel.speedItems) {
                    if (GamePanel.ballItems.indexOf(speedItem) == 0) {
                        continue;
                    } else {
                        speedItem.y += Brick.height;
                    }
                }
                for (PowerUpItem powerUpItem : GamePanel.powerUpItems) {
                    if (GamePanel.ballItems.indexOf(powerUpItem) == 0) {
                        continue;
                    } else {
                        powerUpItem.y += Brick.height;
                    }
                }
                for (DizzinessItem dizzinessItem : GamePanel.dizzinessItems) {
                    if (GamePanel.ballItems.indexOf(dizzinessItem) == 0) {
                        continue;
                    } else {
                        dizzinessItem.y += Brick.height;
                    }
                }
                for (DancingLightItem dancingLightItem : GamePanel.dancingLightItems) {
                    if (GamePanel.ballItems.indexOf(dancingLightItem) == 0) {
                        continue;
                    } else {
                        dancingLightItem.y += Brick.height;
                    }
                }
                GamePanel.newBall((int) GamePanel.ball.x, (int) GamePanel.ball.y);
                for (int k = 0; k < BallItems.collectedBallItems; k++) {
                    GamePanel.newBall((int) GamePanel.ball.x, (int) GamePanel.ball.y);
                }
                BallItems.collectedBallItems = 0;
            }
        }
        else {
            ballInAir = true;
        }
    }


}
