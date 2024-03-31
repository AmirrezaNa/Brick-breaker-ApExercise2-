package Game;

import GameHistory.GameHistory;
import Settings.SettingsPanel;
import Start.StartPagePanel;
import com.google.gson.Gson;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static Game.Ball.ballSize;
import static GameHistory.GameHistory.readScores;
import static GameHistory.GameHistory.saveScores;

public class Brick {

    int x, y , dy;
    final static int width = 48, height = 25;
    int brickValue;

    int brickMainValue;
    public static int score = 0;


    Brick(int x, int y, int brickValue) {
        this.x = x;
        this.y = y;
        dy = 1;
        this.brickMainValue = brickValue;
        this.brickValue = brickValue;
    }

    public void update() {
        for (Brick brick : GamePanel.bricks) {
            if (StartPagePanel.gameLevel == 2) {
                brick.y += 2*dy;
            } else if (StartPagePanel.gameLevel == 0 || StartPagePanel.gameLevel == 1) {
                brick.y += dy;
            }
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
                    if (SettingsPanel.saveNumber == 0) {
                        saveData();
                    }
                    return true;
                }
            }
        }
        return false;

    }

    public static void saveData() {
        Map<String, Integer> scores = new HashMap<>();
        scores.put(StartPagePanel.playerName, score);

        saveScores(scores);
    }



}

