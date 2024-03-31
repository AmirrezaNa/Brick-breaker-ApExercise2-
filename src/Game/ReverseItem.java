package Game;

import Start.StartPagePanel;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static Game.Ball.ballSize;

public class ReverseItem {
    int x, y, dy;
    int value;


    Image image = new ImageIcon("up.png").getImage();
    ReverseItem(int x, int y, int value) {
        this.x = x;
        this.y = y;
        dy = 1;
        this.value = value;
    }

    public void update() {
        for (ReverseItem reverseItem : GamePanel.reverseItems) {
            if (StartPagePanel.gameLevel == 2) {
                reverseItem.y += 4 * dy;
            }
            else {
                reverseItem.y += 2 * dy;
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
            for (ReverseItem reverseItem : GamePanel.reverseItems) {
                if (reverseItem.value > 0) {
                    g.drawImage(image, reverseItem.x, reverseItem.y, Brick.width, Brick.height, null);
                }
            }
        }

    }

    public void checkBallCollision() {
        for (Ball ball : GamePanel.balls) {
            Rectangle ballRect = new Rectangle((int) ball.x, (int) ball.y, ballSize, ballSize);
            for (ReverseItem reverseItem : GamePanel.reverseItems) {
                if (reverseItem.value > 0) {
                    Rectangle reverseRect = new Rectangle(reverseItem.x, reverseItem.y, Brick.width, Brick.height);
                    if (ballRect.intersects(reverseRect)) {
                        reverseAct();
                        reverseItem.value--;
                    }
                }
            }
        }
    }

    public void reverseAct() {
        for (Brick brick : GamePanel.bricks) {
            brick.y -= 2*Brick.height;
        }
    }
}
