package Game;

import Start.StartPagePanel;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import static Game.Ball.ballSize;

public class BombItem {
    int x, y, dy;
    int value;
    static boolean bomb = false;
    static int bombSeconds = 30;
    static int bombRadius = 0;

    Image image = new ImageIcon("bomb.png").getImage();
    BombItem(int x, int y, int value) {
        this.x = x;
        this.y = y;
        dy = 1;
        this.value = value;
    }

    public void update() {
        for (BombItem bombItem : GamePanel.bombItems) {
            if (StartPagePanel.gameLevel == 2) {
                bombItem.y += 4 * dy;
            }
            else {
                bombItem.y += 2 * dy;
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
        if (!GamePanel.bombItems.isEmpty()) {
            for (BombItem bombItem : GamePanel.bombItems) {
                if (bombItem.value > 0) {
                    if (bombSeconds == 30) {
                        g.drawImage(image, bombItem.x, bombItem.y, Brick.width, Brick.height, null);
                    }
                }
                if (bombItem.value == 0 && bomb) {
                    g.setColor(new Color(0xD71111));
                    g.drawOval(bombItem.x, bombItem.y, bombRadius, bombRadius);
                }
            }
        }

    }

    public void checkBallCollision() {
        for (Ball ball : GamePanel.balls) {
            Rectangle ballRect = new Rectangle((int) ball.x, (int) ball.y, ballSize, ballSize);
            for (BombItem bombItem : GamePanel.bombItems) {
                if (bombItem.value > 0) {
                    Rectangle bombRect = new Rectangle(bombItem.x, bombItem.y, ballSize, ballSize);
                    if (ballRect.intersects(bombRect)) {
                        bomb = true;
                        playSound();
                        countDownPowerUpItem();
                        bombItem.value--;
                    }
                }
            }
        }
    }

    public void countDownPowerUpItem() {
        java.util.Timer bombTimer = new Timer();
        TimerTask bombTask = new TimerTask() {
            @Override
            public void run() {
                if (bombSeconds > 0) {
                    bombSeconds--;
                    bombRadius += 4;
                }
                else {
                    bomb = false;
                    bombRadius = 0;
                    bombTimer.cancel();
                }
            }
        };
        bombTimer.scheduleAtFixedRate(bombTask, 0, 200);
    }

    public void playSound() {

        String songPath = "bombExplosion.wav";
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(songPath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void bombAction() {
        for (BombItem bombItem : GamePanel.bombItems) {
            for (Brick brick : GamePanel.bricks) {
                if (Math.abs(brick.y - bombItem.y) <= 150 || Math.abs(brick.x - bombItem.x) <= 150) {
                    brick.brickValue -= 50;
                }
            }
        }

    }


}