package GameHistory;

import Start.StartPagePanel;

import javax.swing.*;
import java.awt.*;

public class GameHistoryFrame extends JFrame {
    public static final int width = 350;
    public static final int height = 550;

    GameHistoryPanel gameHistoryPanel;
    public GameHistoryFrame() {


        this.setSize(width, height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Bricks Breaker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameHistoryPanel = new GameHistoryPanel();
        this.add(gameHistoryPanel);

        this.setVisible(true);
        ImageIcon imageIcon = new ImageIcon("image.png");
        this.setIconImage(imageIcon.getImage());
    }
}
