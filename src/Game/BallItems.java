package Game;

import Start.StartPagePanel;

import java.awt.*;

import static Game.Ball.ballSize;

public class BallItems {
    int x, y, dy;
    int value;
    final int width = ballSize, height = ballSize;

    BallItems(int x, int y) {
        this.x = x;
        this.y = y;
        dy = 1;
        value = 1;
    }

    public void update() {
        for (BallItems ballItem : GamePanel.ballItems) {
            if (StartPagePanel.gameLevel == 2) {
                ballItem.y += 4 * dy;
            }
            else {
                ballItem.y += 2 * dy;
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
        if (DancingLightItem.dancingLightSeconds%2 == 0) {
            for (BallItems ballItem : GamePanel.ballItems) {
                if (ballItem.value > 0) {
                    g.setColor(new Color(0x0C4203));
                    g.fillOval((int) ballItem.x, (int) ballItem.y, (int) ballSize, (int) ballSize);
                }
            }
        }

    }


    static int collectedBallItems = 0;
    public void checkBallCollision() {
        for (Ball ball : GamePanel.balls) {
            Rectangle ballRect = new Rectangle((int) ball.x, (int) ball.y, ballSize, ballSize);
            for (BallItems ballItem : GamePanel.ballItems) {
                if (ballItem.value > 0) {
                    Rectangle ballItemRect = new Rectangle(ballItem.x, ballItem.y, ballSize, ballSize);
                    if (ballRect.intersects(ballItemRect)) {
                        collectedBallItems++;
                        ballItem.value--;
                    }
                }
            }
        }
    }
}
