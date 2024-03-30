package Game;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static Game.Ball.ballSize;

public class SpeedItems {
    int x, y, dy;
    int value;
    static boolean speedUp = false;
    static int speedUpSeconds = 15;

    Image image = new ImageIcon("pngegg.png").getImage();
    SpeedItems(int x, int y, int value) {
        this.x = x;
        this.y = y;
        dy = 1;
        this.value = value;
    }

    public void update() {
        for (SpeedItems speedItem : GamePanel.speedItems) {
            speedItem.y += 2 * dy;
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

        if (!GamePanel.speedItems.isEmpty()) {
            for (SpeedItems speedItem : GamePanel.speedItems) {
                if (speedItem.value > 0) {
                    g.drawImage(image, speedItem.x, speedItem.y, 40, 20, null);

                }
            }
        }

    }

    public void checkBallCollision() {
        for (Ball ball : GamePanel.balls) {
            Rectangle ballRect = new Rectangle((int) ball.x, (int) ball.y, ballSize, ballSize);
            for (SpeedItems speedItem : GamePanel.speedItems) {
                if (speedItem.value > 0) {
                    Rectangle ballItemRect = new Rectangle(speedItem.x, speedItem.y, ballSize, ballSize);
                    if (ballRect.intersects(ballItemRect)) {
                        speedUp = true;
                        countDownSpeedItem();
                        speedItem.value--;
                    }
                }
            }
        }
    }

    public void countDownSpeedItem() {
        java.util.Timer speedTimer = new Timer();
        TimerTask speedTask = new TimerTask() {
            @Override
            public void run() {
                if (speedUpSeconds > 0) {
                    speedUpSeconds--;
                }
                else {
                    SpeedItems.speedUp = false;
                    speedTimer.cancel();
                }
            }
        };
        speedTimer.scheduleAtFixedRate(speedTask, 0, 1000);
    }
}
