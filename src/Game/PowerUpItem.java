package Game;

import Start.StartPagePanel;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static Game.Ball.ballSize;

public class PowerUpItem {
    int x, y, dy;
    int value;
    static boolean powerUp = false;
    static int powerUpSeconds = 15;

    Image image = new ImageIcon("powerUp.png").getImage();
    PowerUpItem(int x, int y, int value) {
        this.x = x;
        this.y = y;
        dy = 1;
        this.value = value;
    }

    public void update() {
        for (PowerUpItem powerUpItem : GamePanel.powerUpItems) {
            if (StartPagePanel.gameLevel == 2) {
                powerUpItem.y += 4 * dy;
            }
            else {
                powerUpItem.y += 2 * dy;
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

        if (!GamePanel.powerUpItems.isEmpty()) {
            for (PowerUpItem powerUpItem : GamePanel.powerUpItems) {
                if (powerUpItem.value > 0) {
                    g.drawImage(image, powerUpItem.x, powerUpItem.y, Brick.width, Brick.height, null);
                }
            }
        }

    }

    public void checkBallCollision() {
        for (Ball ball : GamePanel.balls) {
            Rectangle ballRect = new Rectangle((int) ball.x, (int) ball.y, ballSize, ballSize);
            for (PowerUpItem powerUpItem : GamePanel.powerUpItems) {
                if (powerUpItem.value > 0) {
                    Rectangle powerRect = new Rectangle(powerUpItem.x, powerUpItem.y, ballSize, ballSize);
                    if (ballRect.intersects(powerRect)) {
                        powerUp = true;
                        countDownPowerUpItem();
                        powerUpItem.value--;
                    }
                }
            }
        }
    }

    public void countDownPowerUpItem() {
        java.util.Timer powerUpTimer = new Timer();
        TimerTask powerUpTask = new TimerTask() {
            @Override
            public void run() {
                if (powerUpSeconds > 0) {
                    powerUpSeconds--;
                }
                else {
                    powerUp = false;
                    powerUpTimer.cancel();
                }
            }
        };
        powerUpTimer.scheduleAtFixedRate(powerUpTask, 0, 1000);
    }
}

