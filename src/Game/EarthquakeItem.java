package Game;

import Start.StartPagePanel;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static Game.Ball.ballSize;

public class EarthquakeItem {
    int x, y, dy;
    int value;
    static boolean earthquake = false;
    static int earthquakeSeconds = 10;

    Image image = new ImageIcon("earthquake.png").getImage();
    EarthquakeItem(int x, int y, int value) {
        this.x = x;
        this.y = y;
        dy = 1;
        this.value = value;
    }

    public void update() {
        for (EarthquakeItem earthquakeItem : GamePanel.earthquakeItems) {
            if (StartPagePanel.gameLevel == 2) {
                earthquakeItem.y += 4 * dy;
            }
            else {
                earthquakeItem.y += 2 * dy;
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

        if (!GamePanel.earthquakeItems.isEmpty()) {
            for (EarthquakeItem earthquakeItem : GamePanel.earthquakeItems) {
                if (earthquakeItem.value > 0) {
                    g.drawImage(image, earthquakeItem.x, earthquakeItem.y, Brick.width, Brick.height, null);
                }
            }
        }

    }

    public void checkBallCollision() {

        for (Ball ball : GamePanel.balls) {

            Rectangle ballRect = new Rectangle((int) ball.x, (int) ball.y, ballSize, ballSize);

            for (EarthquakeItem earthquakeItem : GamePanel.earthquakeItems) {
                if (earthquakeItem.value > 0) {
                    Rectangle earthquakeRect = new Rectangle(earthquakeItem.x, earthquakeItem.y, Brick.width, Brick.height);
                    if (ballRect.intersects(earthquakeRect)) {
                        if (ballRect.y <= earthquakeRect.y) {
                            ball.dy = -ball.dy;
                        }

                        if (ballRect.y > earthquakeRect.y) {
                            ball.dy = -ball.dy;
                        } else {
                            ball.dx = -ball.dx;
                        }
                        if (PowerUpItem.powerUp) {
                            earthquakeItem.value -= 2;
                        }
                        else {
                            earthquakeItem.value--;
                        }
                        if (earthquakeItem.value == 0) {
                            earthquake = true;
                            countDownEarthquakeItem();
                        }
                    }

                }

            }
        }
    }

    public void countDownEarthquakeItem() {
        java.util.Timer earthquakeTimer = new Timer();
        TimerTask earthquakeTask = new TimerTask() {
            @Override
            public void run() {
                if (earthquakeSeconds >= 5) {
                    Brick.width -= 4;
                    Brick.height -= 2;
                    earthquakeSeconds--;
                } else if (earthquakeSeconds > 0) {
                    Brick.width += 4;
                    Brick.height += 2;
                } else {
                    earthquake = false;
                    earthquakeTimer.cancel();
                }
            }
        };
        earthquakeTimer.scheduleAtFixedRate(earthquakeTask, 0, 1000);
    }
}
