package Game;

import Start.StartPagePanel;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static Game.Ball.ballSize;

public class DancingLightItem {
    int x, y, dy;
    int value;
    static boolean dancingLight = false;
    static int dancingLightSeconds = 40;

    Image image = new ImageIcon("dancingLight.png").getImage();
    DancingLightItem(int x, int y, int value) {
        this.x = x;
        this.y = y;
        dy = 1;
        this.value = value;
    }

    public void update() {
        for (DancingLightItem dancingLightItem : GamePanel.dancingLightItems) {
            if (StartPagePanel.gameLevel == 2) {
                dancingLightItem.y += 4 * dy;
            }
            else {
                dancingLightItem.y += 2 * dy;
            }
            if (Ball.ballOnDownSide) {
                dy = 0;
            }
            if (!Ball.ballOnDownSide) {
                dy = 1;
            }
        }
        checkBallCollision();
    }

    public void draw(Graphics g, int x) {

        if (!GamePanel.dancingLightItems.isEmpty()) {
            for (DancingLightItem dancingLightItem : GamePanel.dancingLightItems) {
                if (dancingLightItem.value > 0) {
                    g.drawImage(image, dancingLightItem.x, dancingLightItem.y, 40, 20, null);
                }
            }
        }

    }

    public void checkBallCollision() {

        for (Ball ball : GamePanel.balls) {

            Rectangle ballRect = new Rectangle((int) ball.x, (int) ball.y, ballSize, ballSize);

            for (DancingLightItem dancingLightItem : GamePanel.dancingLightItems) {
                if (dancingLightItem.value > 0) {
                    Rectangle dancingLightRect = new Rectangle(dancingLightItem.x, dancingLightItem.y, Brick.width, Brick.height);
                    if (ballRect.intersects(dancingLightRect)) {
                        if (ballRect.y <= dancingLightRect.y) {
                            ball.dy = -ball.dy;
                        }

                        if (ballRect.y > dancingLightRect.y) {
                            ball.dy = -ball.dy;
                        } else {
                            ball.dx = -ball.dx;
                        }
                        if (PowerUpItem.powerUp) {
                            dancingLightItem.value -= 2;
                        }
                        else {
                            dancingLightItem.value--;
                        }
                        if (dancingLightItem.value == 0) {
                            dancingLight = true;
                            countDownDancingLightItem();
                        }
                    }

                }

            }
        }
    }

    public void countDownDancingLightItem() {
        java.util.Timer dancingLightTimer = new Timer();
        TimerTask dancingLightTask = new TimerTask() {
            @Override
            public void run() {
                if (dancingLightSeconds > 0) {
                    dancingLightSeconds--;
                }
                else {
                    dancingLight = false;
                    dancingLightTimer.cancel();
                }
            }
        };
        dancingLightTimer.scheduleAtFixedRate(dancingLightTask, 0, 200);
    }
}

