package Game;

import java.awt.*;

public class Brick {

    int x, y , dy;
    final static int width = 48, height = 25;
    int brickValue;

    int brickMainValue;
    static int score = 0;


    Brick(int x, int y, int brickValue) {
        this.x = x;
        this.y = y;
        dy = 1;
        this.brickMainValue = brickValue;
        this.brickValue = brickValue;
    }

    public void update() {
        for (Brick brick : GamePanel.bricks) {
            brick.y += dy;
            if (Ball.ballOnDownSide) {
                dy = 0;
            }
            if (!Ball.ballOnDownSide) {
                dy = 1;
            }

        }


        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void draw(Graphics g, int y) {
        for (Brick brick : GamePanel.bricks) {
            if (brick.brickValue > 0) {
                g.setColor(new Color(0x770404));
                g.fillRect(brick.x, brick.y, width, height);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(new Color(0x0D283B));
                g2d.setStroke(new BasicStroke(2));
                g2d.drawRect(brick.x, brick.y, width, height);
                g2d.setFont(new Font("Arial", Font.BOLD, 24));
                g2d.drawString(String.valueOf(brick.brickValue), brick.x + 2*width/5, brick.y + 4*height/5);
            }

        }

    }

    public static boolean checkForEndGame() {
        // checking if any brick has reached to the downSide
        for (Brick brick : GamePanel.bricks) {
            if (brick.brickValue > 0) {
                Rectangle brickRect = new Rectangle(brick.x, brick.y, width, height);
                Rectangle downSide = new Rectangle(0, 450, 350, 5);
                if (brickRect.intersects(downSide)) {
                    return true;
                }
            }
        }
        return false;

    }



}

