package Game;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static Game.Ball.ballSize;
import static Game.GamePanel.powerUpItem;

public class DizzinessItem {
    int x, y, dy;
    int value;
    static boolean dizziness = false;
    static int dizzinessSeconds = 15;

    Image image = new ImageIcon("dizziness.png").getImage();
    DizzinessItem(int x, int y, int value) {
        this.x = x;
        this.y = y;
        dy = 1;
        this.value = value;
    }

    public void update() {
        for (DizzinessItem dizzinessItem : GamePanel.dizzinessItems) {
            dizzinessItem.y += 2 * dy;
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

        if (!GamePanel.dizzinessItems.isEmpty()) {
            for (DizzinessItem dizzinessItem : GamePanel.dizzinessItems) {
                if (dizzinessItem.value > 0) {
                    g.drawImage(image, dizzinessItem.x, dizzinessItem.y, 40, 20, null);
                }
            }
        }

    }

    public void checkBallCollision() {
        for (Ball ball : GamePanel.balls) {
            Rectangle ballRect = new Rectangle((int) ball.x, (int) ball.y, ballSize, ballSize);
            for (DizzinessItem dizzinessItem : GamePanel.dizzinessItems) {
                if (dizzinessItem.value > 0) {
                    Rectangle dizzinessRect = new Rectangle(dizzinessItem.x, dizzinessItem.y, ballSize, ballSize);
                    if (ballRect.intersects(dizzinessRect)) {
                        dizziness = true;
                        countDownDizzinessItem();
                        dizzinessItem.value--;
                    }
                }
            }
        }
    }

    public void countDownDizzinessItem() {
        java.util.Timer dizzinessTimer = new Timer();
        TimerTask dizzinessTask = new TimerTask() {
            @Override
            public void run() {
                if (dizzinessSeconds > 0) {
                    dizzinessSeconds--;
                }
                else {
                    dizziness = false;
                    dizzinessTimer.cancel();
                }
            }
        };
        dizzinessTimer.scheduleAtFixedRate(dizzinessTask, 0, 1000);
    }
}
