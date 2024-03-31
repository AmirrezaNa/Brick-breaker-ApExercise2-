package Game;

import Start.StartPagePanel;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static Game.Ball.ballSize;

public class ChanceItem {
    int x, y, dy;
    int value;
    static int anotherChance = 0;


    Image image = new ImageIcon("heart.png").getImage();
    ChanceItem(int x, int y, int value) {
        this.x = x;
        this.y = y;
        dy = 1;
        this.value = value;
    }

    public void update() {
        for (ChanceItem chanceItem : GamePanel.chanceItems) {
            if (StartPagePanel.gameLevel == 2) {
                chanceItem.y += 4 * dy;
            }
            else {
                chanceItem.y += 2 * dy;
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
            for (ChanceItem chanceItem : GamePanel.chanceItems) {
                if (chanceItem.value > 0) {
                    g.drawImage(image, chanceItem.x, chanceItem.y, Brick.width, Brick.height, null);
                }
            }
        }

    }

    public void checkBallCollision() {
        for (Ball ball : GamePanel.balls) {
            Rectangle ballRect = new Rectangle((int) ball.x, (int) ball.y, ballSize, ballSize);
            for (ChanceItem chanceItem : GamePanel.chanceItems) {
                if (chanceItem.value > 0) {
                    Rectangle chanceRect = new Rectangle(chanceItem.x, chanceItem.y, Brick.width, Brick.height);
                    if (ballRect.intersects(chanceRect)) {
                        anotherChance++;
                        chanceItem.value--;
                    }
                }
            }
        }
    }

}
